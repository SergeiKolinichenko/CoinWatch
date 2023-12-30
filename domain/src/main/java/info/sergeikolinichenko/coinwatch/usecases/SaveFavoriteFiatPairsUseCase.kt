package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 03.12.2023 at 19:50 (GMT+3) **/

class SaveFavoriteFiatPairsUseCase @Inject constructor(
  private val repository: CoinWatchRepository
) {
  operator fun invoke(set: Set<String>?) = repository.saveFavoriteFiatPairs(set = set)
}