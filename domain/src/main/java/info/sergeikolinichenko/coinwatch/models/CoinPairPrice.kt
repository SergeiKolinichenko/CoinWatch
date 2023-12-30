package info.sergeikolinichenko.coinwatch.models

/** Created by Sergei Kolinichenko on 26.10.2023 at 17:02 (GMT+3) **/

data class CoinPairPrice(
  val id: String,
  val fromSymbol: String?,
  val fromSymbolImg: String?,
  val toSymbol: String?,
  val toSymbolImg: String?,
  val price: String?,
  val updateDate: String?,
  val updateTime: String?
)