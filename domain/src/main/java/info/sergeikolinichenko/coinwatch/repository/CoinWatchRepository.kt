package info.sergeikolinichenko.coinwatch.repository

import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.models.CoinPairPrice
import kotlinx.coroutines.flow.Flow

/** Created by Sergei Kolinichenko on 07.10.2023 at 18:29 (GMT+3) **/

interface CoinWatchRepository {

  fun saveFavoriteCryptoPairs(set: Set<String>?)
  fun saveFavoriteFiatPairs(set: Set<String>?)
  fun getFavoriteCryptoPairs(): Set<String>?
  fun getFavoriteFiatPairs(): Set<String>?

  suspend fun getCryptoPair(fromSymbol: String?, toSymbols: String?): List<String>?
  suspend fun getMixCoinsList(): List<CoinName> // Flow<List<CoinName>>
  suspend fun getCryptoCoinsList(): List<CoinName> // Flow<List<CoinName>>
  suspend fun getFiatCoinsList(): List<CoinName>
  fun getFavoriteCoinPairsList() : Flow<List<CoinPairPrice>>
  suspend fun updateCoinsValueList()
}