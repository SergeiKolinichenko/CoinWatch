package info.sergeikolinichenko.coinwatch.ui.screens.states

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.utils.AlertDialogData
import info.sergeikolinichenko.coinwatch.utils.SnackbarData

/** Created by Sergei Kolinichenko on 31.10.2023 at 13:03 (GMT+3) **/

sealed class CryptoCoinsScreenStates{

  data object Initial: CryptoCoinsScreenStates()

  data object ShowProgressIndicator: CryptoCoinsScreenStates()

  data object Cancel: CryptoCoinsScreenStates()

  data object ClearSearchText: CryptoCoinsScreenStates()

  data class ShowCoinsList(
    val list: List<CoinName>
  ): CryptoCoinsScreenStates()

  data class ShowSearchingCoinsList(
    val list: List<CoinName>,
  ): CryptoCoinsScreenStates()

  data class ShowSnackbar(
    val data: SnackbarData,
  ): CryptoCoinsScreenStates()

  data class ShowAlertDialog(
    val data: AlertDialogData
  ): CryptoCoinsScreenStates()
}
