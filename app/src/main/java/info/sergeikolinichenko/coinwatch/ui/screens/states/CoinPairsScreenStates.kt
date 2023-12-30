package info.sergeikolinichenko.coinwatch.ui.screens.states

import info.sergeikolinichenko.coinwatch.models.CoinPairPrice
import info.sergeikolinichenko.coinwatch.utils.SnackbarData

/** Created by Sergei Kolinichenko on 15.10.2023 at 21:40 (GMT+3) **/

sealed class CoinPairsScreenStates {

  object Initial: CoinPairsScreenStates()

  object Loading: CoinPairsScreenStates()

  object OpenNavigationDrawer: CoinPairsScreenStates()

  class GetFavoritePairCoins(
    val listCoins: List<CoinPairPrice>
  ): CoinPairsScreenStates()

  class ShowSnackbar(
    val data: SnackbarData,
  ): CoinPairsScreenStates()
}
