package info.sergeikolinichenko.coinwatch.models.dto

import com.squareup.moshi.Json

/** Created by Sergei Kolinichenko on 08.10.2023 at 11:42 (GMT+3) **/

data class CryptoCoinNameDto(
  @Json(name = "Id")
  val coinId: Int? = null,

  @Json(name = "Symbol")
  val coinCode: String? = null,

  @Json(name = "FullName")
  val coinName: String? = null,

  @Json(name = "ImageUrl")
  val coinImgUrl: String? = null
)
