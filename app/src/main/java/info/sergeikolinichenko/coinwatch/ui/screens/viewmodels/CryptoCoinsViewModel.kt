package info.sergeikolinichenko.coinwatch.ui.screens.viewmodels

import android.content.res.Resources
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.sergeikolinichenko.coinwatch.R
import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents.ClearSearchText
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents.CoinsListShown
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents.Initial
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents.ProgressIndicatorShown
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents.PushItemCryptoList
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents.ResaultAlertDialog
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents.SearchbarSearchingText
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates.Cancel
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates.ShowAlertDialog
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates.ShowCoinsList
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates.ShowProgressIndicator
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates.ShowSearchingCoinsList
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates.ShowSnackbar
import info.sergeikolinichenko.coinwatch.usecases.GetCryptoCoinsListUseCase
import info.sergeikolinichenko.coinwatch.usecases.GetCryptoPairUseCase
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCryptoPairsUseCase
import info.sergeikolinichenko.coinwatch.usecases.GetMixCoinsListUseCase
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteCryptoPairsUseCase
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

/** Created by Sergei Kolinichenko on 31.10.2023 at 12:56 (GMT+3) **/

class CryptoCoinsViewModel @Inject constructor(
  getFavoriteCryptoPairsUseCase: GetFavoriteCryptoPairsUseCase,
  private val getCryptoCoinsList: GetCryptoCoinsListUseCase,
  private val getMixCoinsList: GetMixCoinsListUseCase,
  private val getCryptoPair: GetCryptoPairUseCase,
  private val saveFavoriteCryptoPairs: SaveFavoriteCryptoPairsUseCase,
  private val resources: Resources
) : ViewModel() {

  private var listOfCoins = mutableListOf<CoinName>()

  private val _cryptoCoinsScreenStates =
    MutableStateFlow<CryptoCoinsScreenStates>(CryptoCoinsScreenStates.Initial)
  val cryptoCoinsScreenStates: Flow<CryptoCoinsScreenStates> =
    _cryptoCoinsScreenStates.asStateFlow()

  private var searchText: String? = null
  private var coinCode: String? = null
  private var firstItemCoinPair: String? = null
  private var secondItemCoinPair: String? = null
  private var setofCoinPairs: MutableSet<String> =
    getFavoriteCryptoPairsUseCase.invoke()?.toMutableSet() ?: mutableSetOf()

  fun handleEvents(event: CryptoCoinsScreenEvents) {
    viewModelScope.launch {
      when (event) {
        Initial -> handleInitialEvent()
        ProgressIndicatorShown -> handleProgressIndicatorShownEvent()
        CoinsListShown -> handleCoinsListShownEvent()
        ClearSearchText -> handleClearSearchTextEvent()
        is PushItemCryptoList -> handlePushItemCryptoListEvent(event)
        is ResaultAlertDialog -> handleResaultAlertDialogEvent(event)
        is SearchbarSearchingText -> handleSearchbarSearchingTextEvent(event)
        is CryptoCoinsScreenEvents.SnackbarResult -> handleSnackbarResultEvent(event)
      }
    }
  }

  private suspend fun handleInitialEvent() {
    _cryptoCoinsScreenStates.emit(ShowProgressIndicator)
  }

  private suspend fun handleProgressIndicatorShownEvent() {
    val coinsList = if (firstItemCoinPair == null) {
      getCryptoCoinsList.invoke()
    } else {
      getMixCoinsList.invoke()
    }

    listOfCoins = coinsList.toMutableList()
    _cryptoCoinsScreenStates.emit(ShowCoinsList(list = coinsList))
  }

  private suspend fun handleCoinsListShownEvent() {
    showSnackbarOfChoiceCoin()
  }

  private suspend fun handleClearSearchTextEvent() {
    clearSearchText()
  }

  private suspend fun handlePushItemCryptoListEvent(event: PushItemCryptoList) {
    coinCode = event.coinCode
    showAlertDialog()
  }

  private suspend fun handleResaultAlertDialogEvent(event: ResaultAlertDialog) {
    closeAlertDialog()
    clearSearchText()
    handleAlertDialogResult(confirmed = event.reaction)
  }

  private suspend fun handleSearchbarSearchingTextEvent(event: SearchbarSearchingText) {
    this.searchText = event.searchText
    searchCoins()
  }

  private suspend fun handleSnackbarResultEvent(event: CryptoCoinsScreenEvents.SnackbarResult) {
    handleSnackbarResult(result = event.result)
  }

  private suspend fun initialScreen() {
    _cryptoCoinsScreenStates.emit(CryptoCoinsScreenStates.Initial)
  }

  private suspend fun clearSearchText() {
    _cryptoCoinsScreenStates.emit(CryptoCoinsScreenStates.ClearSearchText)
  }

  private suspend fun searchCoins() {
    searchText?.let { searchText ->
      _cryptoCoinsScreenStates.emit(ShowSearchingCoinsList(list =
      listOfCoins.filter { coin ->
        coin.coinCode.lowercase().startsWith(searchText.lowercase())
      }))
    }
  }

  private suspend fun handleAlertDialogResult(confirmed: Boolean) {
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

  private suspend fun handleSnackbarResult(result: SnackbarResult) {
    when (result) {
      SnackbarResult.ActionPerformed -> {
        if (searchText != null) searchCoins()
        initialScreen()
      }

      SnackbarResult.Dismissed -> {
        cancelFromScreen()
      }
    }
  }

  private suspend fun cancelFromScreen() {
    _cryptoCoinsScreenStates.emit(Cancel)
  }

  private suspend fun showAlertDialog() {
    val tittle = firstItemCoinPair.setTitleAlertDialog()
    val text = firstItemCoinPair.setTextAlertDialog()
    _cryptoCoinsScreenStates.emit(
      ShowAlertDialog(
        data = AlertDialogData(
          state = true,
          dialogTitle = resources.getString(tittle),
          dialogText = resources.getString(text, coinCode),
        )
      )
    )
  }

  private suspend fun closeAlertDialog() {
    _cryptoCoinsScreenStates.emit(
      ShowAlertDialog(
        data =
        AlertDialogData(state = false)
      )
    )
  }

  private suspend fun showSnackbarOfChoiceCoin() {
    val message = firstItemCoinPair.setSnackbarText()

    _cryptoCoinsScreenStates.emit(
      ShowSnackbar(
        data = SnackbarData(
          state = true,
          message = resources.getString(message),
          duration = SnackbarDuration.Short
        )
      )
    )
  }

  private suspend fun showSnackbarOfContinueChoice() {

    val message = resources.getString(
      R.string.snackbar_message_do_you_wish_to_continue_choosing_currency_pairs
    )

    _cryptoCoinsScreenStates.emit(
      ShowSnackbar(
        data = SnackbarData(
          state = true,
          message = message,
          actionLabel = resources.getString(R.string.snackbar_action_label_yes),
          duration = SnackbarDuration.Long,
          withDismissAction = true
        )
      )
    )
  }

  private suspend fun showSnackbarOfWrongPair() {
    val message = resources.getString(
      R.string.snackbar_message_resource_does_not_provide_data_on_selected_pair_of_coins,
      "$firstItemCoinPair.$secondItemCoinPair"
    )
    _cryptoCoinsScreenStates.emit(
      ShowSnackbar(
        data = SnackbarData(
          state = true,
          message = message,
          actionLabel = resources.getString(R.string.snackbar_action_label_yes),
          duration = SnackbarDuration.Long,
          withDismissAction = true
        )
      )
    )
  }

  private suspend fun saveCoinPair(): Boolean {

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

  private suspend fun saveCoinPairToSet(): Boolean {
    return checkPairNotRepeated() && checkPairAvailable().also { availabilityCheck ->
      if (availabilityCheck) {
        setofCoinPairs.add("$firstItemCoinPair,$secondItemCoinPair")
        saveFavoriteCryptoPairs.invoke(set = setofCoinPairs)
      }
    }
  }

  private suspend fun checkPairAvailable(): Boolean = run {
    !getCryptoPair.invoke(
      fromSymbol = firstItemCoinPair, toSymbols = secondItemCoinPair
    ).isNullOrEmpty()
  }

  private fun checkPairNotRepeated(): Boolean = run {
    setofCoinPairs.contains("$firstItemCoinPair,$secondItemCoinPair").not()
  }
}