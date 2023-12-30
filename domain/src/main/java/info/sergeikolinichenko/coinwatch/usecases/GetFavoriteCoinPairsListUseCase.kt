package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 26.10.2023 at 17:14 (GMT+3) **/

class GetFavoriteCoinPairsListUseCase @Inject constructor(
  private val repository: CoinWatchRepository
) {

  operator fun invoke() =
    repository.getFavoriteCoinPairsList()
}