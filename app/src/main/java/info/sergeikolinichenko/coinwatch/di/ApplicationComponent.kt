package info.sergeikolinichenko.coinwatch.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import info.sergeikolinichenko.coinwatch.ui.MainActivity
import info.sergeikolinichenko.coinwatch.utils.ViewModelsFactory

/** Created by Sergei Kolinichenko on 06.10.2023 at 21:48 (GMT+3) **/

@ApplicationScope
@Component(modules =[ViewModelsModule::class, DataModule::class])
interface ApplicationComponent {

  fun inject(activity: MainActivity)

  fun getViewModelsFactory(): ViewModelsFactory
  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: Application): ApplicationComponent
  }
}