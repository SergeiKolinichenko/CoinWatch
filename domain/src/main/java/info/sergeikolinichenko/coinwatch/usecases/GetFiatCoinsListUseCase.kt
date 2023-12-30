package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 07.10.2023 at 18:27 (GMT+3) **/

class GetFiatCoinsListUseCase @Inject constructor(
  private val repository: CoinWatchRepository
) {

  suspend operator fun invoke() = repository.getFiatCoinsList()
}