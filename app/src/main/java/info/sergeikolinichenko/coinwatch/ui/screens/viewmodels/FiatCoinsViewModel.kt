package info.sergeikolinichenko.coinwatch.ui.screens.viewmodels

import android.content.res.Resources
import android.util.Log
import androidx.compose.material3.SnackbarDuration
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.sergeikolinichenko.coinwatch.R
import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.ui.screens.events.FiatCoinsScreenEvents
import info.sergeikolinichenko.coinwatch.ui.screens.events.FiatCoinsScreenEvents.*
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates
import info.sergeikolinichenko.coinwatch.ui.screens.states.FiatCoinsScreenStates
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteFiatPairsUseCase
import info.sergeikolinichenko.coinwatch.usecases.GetFiatCoinsListUseCase
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteFiatPairsUseCase
import info.sergeikolinichenko.coinwatch.utils.AlertDialogData
import info.sergeikolinichenko.coinwatch.utils.SnackbarData
import info.sergeikolinichenko.coinwatch.utils.setSnackbarText
import info.sergeikolinichenko.coinwatch.utils.setTextAlertDialog
import info.sergeikolinichenko.coinwatch.utils.setTitleAlertDialog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 24.11.2023 at 13:30 (GMT+3) **/

class FiatCoinsViewModel @Inject constructor(
  getFavoriteFiatPairs: GetFavoriteFiatPairsUseCase,
  private val saveFavoriteFiatPairs: SaveFavoriteFiatPairsUseCase,
  private val getFiatCoinsList: GetFiatCoinsListUseCase,
  private val resources: Resources
) : ViewModel() {

  private var listOfCoins = mutableListOf<CoinName>()
  private var _fiatCoinsScreenStates =
    MutableStateFlow<FiatCoinsScreenStates>(FiatCoinsScreenStates.Initial)
  val fiatCoinsScreenStates: Flow<FiatCoinsScreenStates> = _fiatCoinsScreenStates.asStateFlow()

  private var searchText: String? = null
  private var coinCode: String? = null
  private var firstItemCoinPair: String? = null
  private var secondItemCoinPair: String? = null
  private var setofCoinPairs: MutableSet<String> =
    getFavoriteFiatPairs.invoke()?.toMutableSet() ?: mutableSetOf()

  fun handleEvents(event: FiatCoinsScreenEvents) {
    viewModelScope.launch {
      when (event) {
        Initial -> handleInitialEvent()
        ProgressIndicatorShown -> handleProgressIndicatorShownEvent()
        CoinsListShown -> handleCoinsListShownEvent()
        ClearSearchText -> handleClearSearchTextEvent()
        is PushItemFiatList -> handlePushItemFiatListEvent(event)
        is ResaultAlertDialog -> handleResaultAlertDialogEvent(event)
        is SearchbarSearchingText -> handleSearchbarSearchingTextEvent(event)
        is SnackbarResult -> handleSnackbarResultEvent(event)
      }
    }
  }

  private fun handleSnackbarResultEvent(event: SnackbarResult) {
    handleSnackbarResult(result = event.result)
  }

  private fun handleSnackbarResult(result: androidx.compose.material3.SnackbarResult) {
    when (result) {
      androidx.compose.material3.SnackbarResult.ActionPerformed -> {
        if (searchText != null) searchCoins()
        initialScreen()
      }

      androidx.compose.material3.SnackbarResult.Dismissed -> {
        cancelFromScreen()
      }
    }
  }

  private fun searchCoins() {
    searchText?.let { searchText ->
      _fiatCoinsScreenStates.value = FiatCoinsScreenStates.ShowSearchingCoinsList(
        list = listOfCoins.filter { coin ->
          coin.coinCode.contains(searchText, ignoreCase = true)
        }
      )
    }
  }

  private fun cancelFromScreen() {
    _fiatCoinsScreenStates.value = FiatCoinsScreenStates.Cancel
  }

  private fun initialScreen() {
    _fiatCoinsScreenStates.value = FiatCoinsScreenStates.Initial
  }

  private fun handleSearchbarSearchingTextEvent(event: SearchbarSearchingText) {
    this.searchText = event.searchText
    searchCoins()
  }

  private fun handleResaultAlertDialogEvent(event: ResaultAlertDialog) {
    closeAlertDialog()
    clearSearchText()
    handleAlertDialogResult(confirmed = event.reaction)
  }

  private fun handleAlertDialogResult(confirmed: Boolean) {
    if (confirmed) {
      val success = saveCoinPair()
      if (firstItemCoinPair != null && secondItemCoinPair != null) {

        if (success) showSnackbarOfContinueChoice()
        else showSnackbarOfWrongPair()

        firstItemCoinPair = null
        secondItemCoinPair = null
      } else {
        initialScreen()
      }
    }
  }

  private fun showSnackbarOfWrongPair() {
    val message = resources.getString(
      R.string.snackbar_message_resource_does_not_provide_data_on_selected_pair_of_coins,
      "$firstItemCoinPair.$secondItemCoinPair"
    )
    _fiatCoinsScreenStates.value =
      FiatCoinsScreenStates.ShowSnackbar(
        data = SnackbarData(
          state = true,
          message = message,
          actionLabel = resources.getString(R.string.snackbar_action_label_yes),
          duration = SnackbarDuration.Long,
          withDismissAction = true
        )
      )

  }

  private fun showSnackbarOfContinueChoice() {
    val message = resources.getString(
      R.string.snackbar_message_do_you_wish_to_continue_choosing_currency_pairs
    )
    _fiatCoinsScreenStates.value = FiatCoinsScreenStates.ShowSnackbar(
      data = SnackbarData(
        state = true,
        message = message,
        actionLabel = resources.getString(R.string.snackbar_action_label_yes),
        duration = SnackbarDuration.Long,
        withDismissAction = true
      )
    )
  }

  private fun saveCoinPair(): Boolean {

    if (coinCode == null) return false
    if (firstItemCoinPair == null) {
      firstItemCoinPair = coinCode
      if (searchText != null) searchCoins()
      coinCode = null
      return false
    }
    if (firstItemCoinPair == secondItemCoinPair) {
      coinCode = null
      return false
    }
    secondItemCoinPair = coinCode
    val result = saveCoinPairToSet()
    coinCode = null
    return result
  }

  private fun saveCoinPairToSet(): Boolean {
    return checkPairNotRepeated().also { pairNotRepeated ->
      if (pairNotRepeated) {
        setofCoinPairs.add("$firstItemCoinPair,$secondItemCoinPair")
        saveFavoriteFiatPairs.invoke(set = setofCoinPairs)
      }
    }
  }

  private suspend fun handlePushItemFiatListEvent(event: PushItemFiatList) {
    coinCode = event.coinCode
    showAlertDialog()
  }

  private suspend fun showAlertDialog() {
    val tittle = firstItemCoinPair.setTitleAlertDialog()
    val text = firstItemCoinPair.setTextAlertDialog()
    _fiatCoinsScreenStates.emit(
      FiatCoinsScreenStates.ShowAlertDialog(
        data = AlertDialogData(
          state = true,
          dialogTitle = resources.getString(tittle),
          dialogText = resources.getString(text, coinCode)
        )
      )
    )
  }

  private fun closeAlertDialog() {
    _fiatCoinsScreenStates.value = FiatCoinsScreenStates.ShowAlertDialog(
        data = AlertDialogData(state = false)
      )
  }

  private fun handleClearSearchTextEvent() {
    clearSearchText()
  }

  private suspend fun handleCoinsListShownEvent() {
    showSnackbarOfChoiceCoin()
  }

  private fun handleInitialEvent() {
    _fiatCoinsScreenStates.value = FiatCoinsScreenStates.ShowProgressIndicator
  }

  private suspend fun handleProgressIndicatorShownEvent() {
    listOfCoins = getFiatCoinsList.invoke().toMutableList()
    _fiatCoinsScreenStates.value = FiatCoinsScreenStates.ShowCoinsList(
      list = listOfCoins
    )
  }
  
  private suspend fun showSnackbarOfChoiceCoin() {
    val message = firstItemCoinPair.setSnackbarText()

    _fiatCoinsScreenStates.emit(
      FiatCoinsScreenStates.ShowSnackbar(
        data = SnackbarData(
          state = true,
          message = resources.getString(message),
          duration = SnackbarDuration.Short
        )
      )
    )
  }

  private fun clearSearchText() {
    _fiatCoinsScreenStates.value = FiatCoinsScreenStates.ClearSearchText
  }

  private fun checkPairNotRepeated(): Boolean = run {
    setofCoinPairs.contains("$firstItemCoinPair,$secondItemCoinPair").not()
  }
}