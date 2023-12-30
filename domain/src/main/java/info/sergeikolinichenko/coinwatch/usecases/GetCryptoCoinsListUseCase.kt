package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 25.11.2023 at 16:35 (GMT+3) **/

class GetCryptoCoinsListUseCase@Inject constructor(
  private val repository: CoinWatchRepository) {

  suspend operator fun invoke() = repository.getCryptoCoinsList()
}