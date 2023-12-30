package info.sergeikolinichenko.coinwatch.ui.screens.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Created by Sergei Kolinichenko on 24.10.2023 at 21:38 (GMT+3) **/

@Composable
fun ShowProgressIndicator(state: Boolean = false) {

  when{
    state -> {
      Box(
        modifier = Modifier
          .fillMaxSize(),
        contentAlignment = Alignment.Center
      ) {
        CircularProgressIndicator(
          modifier = Modifier
            .size(100.dp)
            .fillMaxSize(),
          strokeWidth = 10.dp
        )
      }
    }
  }
}