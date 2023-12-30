package info.sergeikolinichenko.coinwatch.di;

import android.app.Application;
import android.content.res.Resources;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class ViewModelsModule_Companion_ProvideRecoursesFactory implements Factory<Resources> {
  private final Provider<Application> applicationProvider;

  public ViewModelsModule_Companion_ProvideRecoursesFactory(
      Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Resources get() {
    return provideRecourses(applicationProvider.get());
  }

  public static ViewModelsModule_Companion_ProvideRecoursesFactory create(
      Provider<Application> applicationProvider) {
    return new ViewModelsModule_Companion_ProvideRecoursesFactory(applicationProvider);
  }

  public static Resources provideRecourses(Application application) {
    return Preconditions.checkNotNullFromProvides(ViewModelsModule.Companion.provideRecourses(application));
  }
}
