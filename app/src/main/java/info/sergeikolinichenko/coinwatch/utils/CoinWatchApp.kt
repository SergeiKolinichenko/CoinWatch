package info.sergeikolinichenko.coinwatch.utils

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import info.sergeikolinichenko.coinwatch.di.ApplicationComponent
import info.sergeikolinichenko.coinwatch.di.DaggerApplicationComponent

/** Created by Sergei Kolinichenko on 06.10.2023 at 21:38 (GMT+3) **/

class CoinWatchApp: Application() {

  val component: ApplicationComponent by lazy {
    DaggerApplicationComponent.factory().create(this)
  }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
  return (LocalContext.current.applicationContext as  CoinWatchApp).component
}