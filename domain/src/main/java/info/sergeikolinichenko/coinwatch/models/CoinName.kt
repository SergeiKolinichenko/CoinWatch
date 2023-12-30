package info.sergeikolinichenko.coinwatch.models

/** Created by Sergei Kolinichenko on 13.10.2023 at 20:58 (GMT+3) **/

data class CoinName(
  val coinId: Int,
  val coinCode: String,
  val coinName: String,
  val coinImgUrl: String
)
