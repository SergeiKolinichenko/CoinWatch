package info.sergeikolinichenko.coinwatch.ui.screens.states

import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.utils.AlertDialogData
import info.sergeikolinichenko.coinwatch.utils.SnackbarData

/** Created by Sergei Kolinichenko on 09.12.2023 at 20:57 (GMT+3) **/

sealed class FiatCoinsScreenStates {

  data object Initial: FiatCoinsScreenStates()

  data object ShowProgressIndicator: FiatCoinsScreenStates()

  data object Cancel: FiatCoinsScreenStates()

  data object ClearSearchText: FiatCoinsScreenStates()

  data class ShowCoinsList(
    val list: List<CoinName>
  ): FiatCoinsScreenStates()

  data class ShowSearchingCoinsList(
    val list: List<CoinName>,
  ): FiatCoinsScreenStates()

  data class ShowAlertDialog(
    val data: AlertDialogData
  ): FiatCoinsScreenStates()

  data class ShowSnackbar(
    val data: SnackbarData,
  ): FiatCoinsScreenStates()
}