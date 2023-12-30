package info.sergeikolinichenko.coinwatch.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.sergeikolinichenko.coinwatch.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

/** Created by Sergei Kolinichenko on 06.10.2023 at 21:45 (GMT+3) **/

@ApplicationScope
class ViewModelsFactory @Inject constructor(
  private val viewModelProviders:
  @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return viewModelProviders[modelClass]?.get() as T
  }
}