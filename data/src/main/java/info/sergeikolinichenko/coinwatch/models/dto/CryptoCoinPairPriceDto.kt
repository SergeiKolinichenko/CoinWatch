package info.sergeikolinichenko.coinwatch.models.dto

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/** Created by Sergei Kolinichenko on 26.10.2023 at 19:45 (GMT+3) **/

data class CryptoPairPriceContainerDto(
  @SerializedName("RAW")
  @Expose
  val jsonRow: JsonObject? = null,
)

data class CryptoPairPriceDto(
  @Json(name = "FROMSYMBOL")
  val fromSymbol: String?,

  @Json(name = "IMAGEURL")
  val fromSymbolImg: String?,

  @Json(name = "TOSYMBOL")
  val toSymbol: String?,

  @Json(name = "PRICE")
  val price: String?,

  @Json(name = "LASTUPDATE")
  val update: String?
)
