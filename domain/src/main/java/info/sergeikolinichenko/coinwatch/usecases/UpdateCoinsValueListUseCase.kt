package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 17.11.2023 at 20:40 (GMT+3) **/

class UpdateCoinsValueListUseCase @Inject constructor(
  private val repository: CoinWatchRepository
) {

  suspend operator fun invoke() {
    repository.updateCoinsValueList()
  }
}