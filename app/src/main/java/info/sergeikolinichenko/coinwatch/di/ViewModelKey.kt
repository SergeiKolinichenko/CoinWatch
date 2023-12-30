package info.sergeikolinichenko.coinwatch.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/** Created by Sergei Kolinichenko on 06.10.2023 at 21:46 (GMT+3) **/
@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
