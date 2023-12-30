package info.sergeikolinichenko.coinwatch.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/** Created by Sergei Kolinichenko on 26.10.2023 at 18:28 (GMT+3) **/

object ConversionTools {

  fun Float.getIntString() = String.format("%.10f", this)

  fun Long?.convertTimestampToTime(): String {
    if (this == null) return ""
    val stamp = Timestamp(this * 1000)
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
  }

  fun Long?.convertTimestampToDate(): String {
    if (this == null) return ""
    val stamp = Timestamp(this * 1000)
    val date = Date(stamp.time)
    val pattern = "dd.MM.yy"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
  }
}