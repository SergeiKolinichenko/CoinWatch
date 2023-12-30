package info.sergeikolinichenko.coinwatch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import info.sergeikolinichenko.coinwatch.ui.screens.compose.Navigation
import info.sergeikolinichenko.coinwatch.ui.theme.CoinWatchTheme
import info.sergeikolinichenko.coinwatch.utils.CoinWatchApp

/*
This is where ModalNavigationDrawer navigates the application using Compose NavHostController.
In the content ModalNavigationDrawer calls the required Compose screen.
*/

class MainActivity : ComponentActivity() {

  private val component by lazy { (application as CoinWatchApp).component }

  override fun onCreate(savedInstanceState: Bundle?) {
    component.inject(this)
    super.onCreate(savedInstanceState)

    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      CoinWatchTheme {
        Surface(
          modifier = Modifier
            .fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {

          Navigation()
        }
      }
    }
  }
}