package info.sergeikolinichenko.coinwatch.usecases

import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 24.11.2023 at 13:43 (GMT+3) **/

class GetCryptoPairUseCase @Inject constructor(
  private val repository: CoinWatchRepository
) {
  suspend operator fun invoke(
    fromSymbol: String?,
    toSymbols: String?
  ) = repository.getCryptoPair(
    fromSymbol = fromSymbol,
    toSymbols = toSymbols
  )
}