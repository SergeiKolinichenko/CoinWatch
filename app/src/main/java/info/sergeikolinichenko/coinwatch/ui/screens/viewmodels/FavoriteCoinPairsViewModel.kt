package info.sergeikolinichenko.coinwatch.ui.screens.viewmodels

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.sergeikolinichenko.coinwatch.models.CoinPairPrice
import info.sergeikolinichenko.coinwatch.ui.screens.events.CoinPairsScreenEvents
import info.sergeikolinichenko.coinwatch.ui.screens.states.CoinPairsScreenStates
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCoinPairsListUseCase
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCryptoPairsUseCase
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteCryptoPairsUseCase
import info.sergeikolinichenko.coinwatch.utils.SnackbarData
import info.sergeikolinichenko.coinwatch.utils.mergeWith
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 06.10.2023 at 21:45 (GMT+3) **/

class FavoriteCoinPairsViewModel @Inject constructor(
  private val getCoinPairsList: GetFavoriteCoinPairsListUseCase,
  private val loadFavoriteCoinPairs: GetFavoriteCryptoPairsUseCase,
  private val saveFavoriteCoinPairs: SaveFavoriteCryptoPairsUseCase
) : ViewModel() {

  private val openNavigationDrawer = MutableSharedFlow<CoinPairsScreenStates>()
  private val showSnackbar = MutableSharedFlow<SnackbarData>()

  private val updatePairsList = MutableSharedFlow<List<CoinPairPrice>>()

  val coinPairsScreenStates: Flow<CoinPairsScreenStates> =
    getCoinPairsList.invoke()
      .filter { it.isNotEmpty() }
      .map {
        CoinPairsScreenStates.GetFavoritePairCoins(listCoins = it) as CoinPairsScreenStates
      }
      .onStart {
        if (checkFavoritePairs()) emit(CoinPairsScreenStates.Loading)
        else showMessageOfFavoritePairs()
      }
      .mergeWith(
        updatePairsList
          .filter { it.isNotEmpty() }
          .map {
            CoinPairsScreenStates.GetFavoritePairCoins(listCoins = it) as CoinPairsScreenStates
          }
//          .onStart { emit(CoinPairsScreenStates.ProgressIndicatorShown) }
      )
      .mergeWith(
        showSnackbar
          .map {
            CoinPairsScreenStates.ShowSnackbar(data = it) as CoinPairsScreenStates
          }
      )
      .mergeWith(openNavigationDrawer)

  fun handleEvent(event: CoinPairsScreenEvents) {
    when (event) {
      is CoinPairsScreenEvents.Initial -> {}
      is CoinPairsScreenEvents.DeletePairFromSet -> deletePairFromSet(event.item)
      is CoinPairsScreenEvents.SnackbarResult -> {
        handleSnackbarResult(
          withDismissAction = event.withDismissAction,
          result = event.result)
      }
    }
  }

  private fun deletePairFromSet(item: CoinPairPrice) {
    val fromSymbol = item.fromSymbol
    val toSymbol = item.toSymbol
    val loadSet = loadFavoriteCoinPairs.invoke()
    val set = loadSet?.filter {
      it.substringBefore(",") != fromSymbol && it.substringAfter(",") != toSymbol
    }?.toSet()
    saveFavoriteCoinPairs.invoke(set)
    updatePairsList()
  }

  private fun checkFavoritePairs(): Boolean {
    return !loadFavoriteCoinPairs.invoke().isNullOrEmpty()
  }

  private fun handleSnackbarResult(
    withDismissAction: Boolean,
    result: SnackbarResult
  ) {
    when (result) {
      SnackbarResult.ActionPerformed -> {}
      SnackbarResult.Dismissed -> {
          openNavigationDrawer()
      }
    }
  }

  private fun openNavigationDrawer() {
    viewModelScope.launch {
      openNavigationDrawer.emit(CoinPairsScreenStates.OpenNavigationDrawer)
    }
  }

  private fun updatePairsList() {
    viewModelScope.launch {
      getCoinPairsList.invoke().collect {
        updatePairsList.emit(it)
      }
    }
  }

  private fun showMessageOfFavoritePairs() {
    showSnackBar(
      state = true,
      message = "Favorite pairs updated"
    )
  }

  private fun showSnackBar(
    state: Boolean,
    message: String,
    actionLabel: String? = null,
    duration: SnackbarDuration = SnackbarDuration.Short,
    withDismissAction: Boolean = false
  ) {
    viewModelScope.launch {
      showSnackbar.emit(
        SnackbarData(
          state = state,
          message = message,
          actionLabel = actionLabel,
          duration = duration,
          withDismissAction = withDismissAction
        )
      )
    }
  }
}