package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 10.10.2023 at 13:22 (GMT+3) **/

class SaveFavoriteCryptoPairsUseCase @Inject constructor(
private val repository: CoinWatchRepository
) {
  operator fun invoke(set: Set<String>?) = repository.saveFavoriteCryptoPairs(set = set)
}