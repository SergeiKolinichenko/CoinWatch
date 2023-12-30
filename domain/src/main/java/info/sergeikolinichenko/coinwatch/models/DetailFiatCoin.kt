package info.sergeikolinichenko.coinwatch.models

/** Created by Sergei Kolinichenko on 03.11.2023 at 12:51 (GMT+3) **/

data class DetailFiatCoin(
  val fiatCoinName: String,
  val fiatCoinCode: String,
  val fiatCoinSymbol: String,
  val fiatCoinCountry: String,
  val fiatCountryFlag: String
)
