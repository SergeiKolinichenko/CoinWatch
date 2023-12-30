package info.sergeikolinichenko.coinwatch.models.dto

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 07.12.2023 at 20:59 (GMT+3) **/

data class FiatPairPriceContainerDto(
  @SerializedName("base")
  val fromSymbol: String?,
  @SerializedName("rates")
  val toSymbols: JsonObject?,
  @SerializedName("timestamp")
  val update: Int?
)

data class FiatPairPriceDto(
  val fromSymbol: String?,
  val toSymbol: String?,
  val price: String?,
  val update: Int?
)
