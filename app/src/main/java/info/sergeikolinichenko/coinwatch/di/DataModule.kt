package info.sergeikolinichenko.coinwatch.di

import android.app.Application
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import info.sergeikolinichenko.coinwatch.preferences.PreferencesCoinWatch
import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository
import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepositoryImpl

/** Created by Sergei Kolinichenko on 07.10.2023 at 18:24 (GMT+3) **/
@Module
interface DataModule {
  @Binds
  @ApplicationScope
  fun bindRepository(impl: CoinWatchRepositoryImpl): CoinWatchRepository

  companion object {
    @Provides
    @ApplicationScope
    fun provideSharedPreferences(application: Application): SharedPreferences {
      return PreferencesCoinWatch.getInstance(application)
    }

  }
}