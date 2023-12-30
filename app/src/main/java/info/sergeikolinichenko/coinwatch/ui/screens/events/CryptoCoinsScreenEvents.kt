package info.sergeikolinichenko.coinwatch.ui.screens.events


/** Created by Sergei Kolinichenko on 05.11.2023 at 20:46 (GMT+3) **/

sealed class CryptoCoinsScreenEvents{

  data object Initial: CryptoCoinsScreenEvents()
  data object ProgressIndicatorShown: CryptoCoinsScreenEvents()
  data object CoinsListShown: CryptoCoinsScreenEvents()
  data object ClearSearchText: CryptoCoinsScreenEvents()

  data class PushItemCryptoList(
    val coinCode: String
  ): CryptoCoinsScreenEvents()

  data class SearchbarSearchingText(
    val searchText: String
  ): CryptoCoinsScreenEvents()

  data class ResaultAlertDialog(
    val reaction: Boolean
  ): CryptoCoinsScreenEvents()

  data class SnackbarResult(
    val result: androidx.compose.material3.SnackbarResult
  ): CryptoCoinsScreenEvents()

}
