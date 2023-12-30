package info.sergeikolinichenko.coinwatch.models.dto

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Created by Sergei Kolinichenko on 08.10.2023 at 11:43 (GMT+3) **/

data class CoinNamesContainerDto(
  @SerializedName("Data")
  @Expose
  val json: JsonObject? = null
)
