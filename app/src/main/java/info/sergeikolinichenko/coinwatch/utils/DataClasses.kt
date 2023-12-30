package info.sergeikolinichenko.coinwatch.utils

import androidx.compose.material3.SnackbarDuration
import androidx.compose.ui.graphics.vector.ImageVector

/** Created by Sergei Kolinichenko on 14.11.2023 at 13:22 (GMT+3) **/

data class AlertDialogData(
  val state: Boolean,
  val dialogTitle: String? = null,
  val dialogText: String? = null,
  val icon: ImageVector? = null,
  val dialogTextConfirmButton: String? = null,
  val dialogTextDismissButton: String? = null
)

data class SnackbarData(
  val state: Boolean,
  val message: String,
  val actionLabel: String? = null,
  val duration: SnackbarDuration = SnackbarDuration.Short,
  val withDismissAction: Boolean = false
)