package info.sergeikolinichenko.coinwatch.di;

import android.app.Application;
import android.content.SharedPreferences;
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
public final class DataModule_Companion_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
  private final Provider<Application> applicationProvider;

  public DataModule_Companion_ProvideSharedPreferencesFactory(
      Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreferences(applicationProvider.get());
  }

  public static DataModule_Companion_ProvideSharedPreferencesFactory create(
      Provider<Application> applicationProvider) {
    return new DataModule_Companion_ProvideSharedPreferencesFactory(applicationProvider);
  }

  public static SharedPreferences provideSharedPreferences(Application application) {
    return Preconditions.checkNotNullFromProvides(DataModule.Companion.provideSharedPreferences(application));
  }
}
