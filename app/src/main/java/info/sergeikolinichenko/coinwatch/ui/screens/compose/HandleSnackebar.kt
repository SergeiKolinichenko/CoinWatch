package info.sergeikolinichenko.coinwatch.ui.screens.compose

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import info.sergeikolinichenko.coinwatch.utils.SnackbarData

/** Created by Sergei Kolinichenko on 14.11.2023 at 13:32 (GMT+3) **/
@Composable
fun HandleSnackebar(
  snackbarHostState: SnackbarHostState,
  snackbarData: SnackbarData,
  onResultSnackbar: (result: SnackbarResult, withDismissAction: Boolean) -> Unit
) {

  val state = snackbarData.state

  if (!state) return

  val message = snackbarData.message
  val actionLabel = snackbarData.actionLabel
  val duration = snackbarData.duration
  val withDismissAction = snackbarData.withDismissAction

  LaunchedEffect(message) {
    val result = snackbarHostState.showSnackbar(
      message = message,
      actionLabel = actionLabel,
      duration = duration,
      withDismissAction = withDismissAction
    )
    onResultSnackbar(result, withDismissAction)
  }
}