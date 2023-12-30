package info.sergeikolinichenko.coinwatch.utils;

import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("info.sergeikolinichenko.coinwatch.di.ApplicationScope")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ViewModelsFactory_Factory implements Factory<ViewModelsFactory> {
  private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelProvidersProvider;

  public ViewModelsFactory_Factory(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelProvidersProvider) {
    this.viewModelProvidersProvider = viewModelProvidersProvider;
  }

  @Override
  public ViewModelsFactory get() {
    return newInstance(viewModelProvidersProvider.get());
  }

  public static ViewModelsFactory_Factory create(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelProvidersProvider) {
    return new ViewModelsFactory_Factory(viewModelProvidersProvider);
  }

  public static ViewModelsFactory newInstance(
      Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviders) {
    return new ViewModelsFactory(viewModelProviders);
  }
}
