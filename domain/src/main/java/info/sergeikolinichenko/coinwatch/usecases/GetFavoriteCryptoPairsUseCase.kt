package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 10.10.2023 at 14:10 (GMT+3) **/

class GetFavoriteCryptoPairsUseCase @Inject constructor(
  private val repository: CoinWatchRepository
) {
  operator fun invoke() = repository.getFavoriteCryptoPairs()
}