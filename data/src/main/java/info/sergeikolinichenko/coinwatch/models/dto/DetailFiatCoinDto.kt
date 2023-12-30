package info.sergeikolinichenko.coinwatch.models.dto

import com.squareup.moshi.Json

/** Created by Sergei Kolinichenko on 03.11.2023 at 14:23 (GMT+3) **/

data class DetailFiatCoinDto(

  @Json(name = "Currency")
  val fiatCoinName: String,

  @Json(name = "Code")
  val fiatCoinCode: String,

  @Json(name = "Symbol")
  val fiatCoinSymbol: String,

  @Json(name = "CountryName")
  val fiatCoinCountry: String,

  @Json(name = "Flag")
  val fiatCountryFlagImg: String
)
