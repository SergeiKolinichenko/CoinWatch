package info.sergeikolinichenko.coinwatch.models.db

/** Created by Sergei Kolinichenko on 03.11.2023 at 12:51 (GMT+3) **/

data class DetailFiatCoinDb(
  val fiatCoinName: String,
  val fiatCoinCode: String,
  val fiatCoinSymbol: String,
  val fiatCoinCountry: String,
  val fiatCountryFlag: String
)
