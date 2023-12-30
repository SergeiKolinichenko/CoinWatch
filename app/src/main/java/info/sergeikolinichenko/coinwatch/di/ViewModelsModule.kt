package info.sergeikolinichenko.coinwatch.di

import android.app.Application
import android.content.res.Resources
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.FavoriteCoinPairsViewModel
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.CryptoCoinsViewModel
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.FiatCoinsViewModel

/** Created by Sergei Kolinichenko on 07.10.2023 at 14:46 (GMT+3) **/

@Module
interface ViewModelsModule {
  @Binds
  @IntoMap
  @ViewModelKey(FavoriteCoinPairsViewModel::class)
  fun bindFavoriteCoinPairsViewModel(viewModel: FavoriteCoinPairsViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(CryptoCoinsViewModel::class)
  fun bindCryptoCoinsViewModel(viewModel: CryptoCoinsViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(FiatCoinsViewModel::class)
  fun bindFiatCoinsViewModel(viewModel: FiatCoinsViewModel): ViewModel

  companion object {
    @Provides
    @ApplicationScope
    fun provideRecourses(
      application: Application
    ): Resources = application.resources

  }
}