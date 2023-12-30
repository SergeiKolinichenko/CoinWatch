package info.sergeikolinichenko.coinwatch.ui.screens.events

import info.sergeikolinichenko.coinwatch.models.CoinPairPrice

/** Created by Sergei Kolinichenko on 23.11.2023 at 18:17 (GMT+3) **/

sealed class CoinPairsScreenEvents {

  object Initial: CoinPairsScreenEvents()

  class DeletePairFromSet(
    val item: CoinPairPrice
  ): CoinPairsScreenEvents()

  class SnackbarResult(
    val withDismissAction: Boolean = false,
    val result: androidx.compose.material3.SnackbarResult
  ): CoinPairsScreenEvents()
}
