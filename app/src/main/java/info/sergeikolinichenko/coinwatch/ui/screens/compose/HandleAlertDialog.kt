package info.sergeikolinichenko.coinwatch.ui.screens.compose

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.sergeikolinichenko.coinwatch.R
import info.sergeikolinichenko.coinwatch.utils.AlertDialogData

/** Created by Sergei Kolinichenko on 04.11.2023 at 20:26 (GMT+3) **/

@Composable
fun HandleAlertDialog(
  alertDialogData: AlertDialogData?,
  onPushDialogButtons: (reaction: Boolean) -> Unit
) {

  var alertDialogState by remember { mutableStateOf(false) }
  if (alertDialogData != null) {
    alertDialogState = alertDialogData.state
  }

  if (!alertDialogState) return

  val title: String = alertDialogData?.dialogTitle ?: ""
  val text: String = alertDialogData?.dialogText ?: ""
  val icon: ImageVector = alertDialogData?.icon ?: Icons.Default.Info
  val textConfirmButton: String = alertDialogData?.dialogTextConfirmButton ?: stringResource(R.string.alert_dialog_button_confirm)
  val textDismissButton: String = alertDialogData?.dialogTextDismissButton ?: stringResource(R.string.alert_dialog_button_dismiss)

  AlertDialog(
    icon = {
      Icon(
        icon,
        modifier = Modifier
          .size(50.dp),
        contentDescription = "Alert Dialog Icon"
      )
    },
    title = {
      Text(
        text = title,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        fontSize = 30.sp,
        fontWeight = FontWeight.W900
      )
    },
    text = {
      Text(
        text = text,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        fontWeight = FontWeight.W500
      )
    },
    onDismissRequest = {
      onPushDialogButtons(false)
    },
    confirmButton = {
      TextButton(
        onClick = {
          onPushDialogButtons(true)
        }
      ) {
        Text(
          text = textConfirmButton,
          textAlign = TextAlign.Start,
          fontFamily = FontFamily.SansSerif,
          fontSize = 24.sp,
          fontWeight = FontWeight.W700
        )
      }
    },
    dismissButton = {
      TextButton(
        onClick = {
          onPushDialogButtons(false)
        }
      ) {
        Text(
          text = textDismissButton,
          textAlign = TextAlign.Start,
          fontFamily = FontFamily.SansSerif,
          fontSize = 24.sp,
          fontWeight = FontWeight.W600
        )
      }
    }
  )
}