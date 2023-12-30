package info.sergeikolinichenko.coinwatch.ui.screens.events

/** Created by Sergei Kolinichenko on 09.12.2023 at 21:04 (GMT+3) **/

sealed class FiatCoinsScreenEvents {
  data object Initial: FiatCoinsScreenEvents()

  data object ProgressIndicatorShown: FiatCoinsScreenEvents()

  data object CoinsListShown: FiatCoinsScreenEvents()

  data object ClearSearchText: FiatCoinsScreenEvents()

  data class PushItemFiatList(
    val coinCode: String
  ): FiatCoinsScreenEvents()

  data class SearchbarSearchingText(
    val searchText: String
  ): FiatCoinsScreenEvents()

  data class ResaultAlertDialog(
    val reaction: Boolean
  ): FiatCoinsScreenEvents()

  data class SnackbarResult(
    val result: androidx.compose.material3.SnackbarResult
  ): FiatCoinsScreenEvents()
}