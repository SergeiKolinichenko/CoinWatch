package info.sergeikolinichenko.coinwatch.models.db

/** Created by Sergei Kolinichenko on 26.10.2023 at 19:45 (GMT+3) **/

data class CoinPairPriceDb(
  val fromSymbol: String,
  val fromSymbolImg: String?,
  val toSymbol: String,
  val toSymbolSym: String?,
  val price: String?,
  val updateDate: String?,
  val updateTime: String?
)
