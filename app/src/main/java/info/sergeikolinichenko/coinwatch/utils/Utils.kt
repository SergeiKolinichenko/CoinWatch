package info.sergeikolinichenko.coinwatch.utils

import info.sergeikolinichenko.coinwatch.R
import info.sergeikolinichenko.coinwatch.models.CoinName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.merge

/** Created by Sergei Kolinichenko on 16.10.2023 at 17:55 (GMT+3) **/

fun <T> Flow<T>.mergeWith(another: Flow<T>): Flow<T> {
  return merge(this, another)
}

fun String?.setTitleAlertDialog(): Int {
  return if (this == null) {
    R.string.alert_dialog_title_selecting_the_first_character
  } else {
    R.string.alert_dialog_title_selecting_the_second_character
  }
}

fun String?.setTextAlertDialog(): Int {
  return if (this == null) {
    R.string.alert_dialog_text_is_the_first_element_of_a_currency_pair
  } else {
    R.string.alert_dialog_text_is_the_second_element_of_a_currency_pair
  }
}

fun String?.setSnackbarText(): Int {
  return if (this == null) {
    R.string.snackbar_message_select_the_first_coin_of_the_pair
  } else {
    R.string.snackbar_message_select_the_second_coin_of_the_pair
  }
}