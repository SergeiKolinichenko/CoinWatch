package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 03.12.2023 at 19:51 (GMT+3) **/

class GetFavoriteFiatPairsUseCase @Inject constructor(
  private val repository: CoinWatchRepository
) {
  operator fun invoke() = repository.getFavoriteFiatPairs()
}