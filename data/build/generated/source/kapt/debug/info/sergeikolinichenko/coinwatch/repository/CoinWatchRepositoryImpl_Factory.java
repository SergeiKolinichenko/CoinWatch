package info.sergeikolinichenko.coinwatch.repository;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class CoinWatchRepositoryImpl_Factory implements Factory<CoinWatchRepositoryImpl> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<CoinWatchMapper> mapperProvider;

  public CoinWatchRepositoryImpl_Factory(Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<CoinWatchMapper> mapperProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.mapperProvider = mapperProvider;
  }

  @Override
  public CoinWatchRepositoryImpl get() {
    return newInstance(sharedPreferencesProvider.get(), mapperProvider.get());
  }

  public static CoinWatchRepositoryImpl_Factory create(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<CoinWatchMapper> mapperProvider) {
    return new CoinWatchRepositoryImpl_Factory(sharedPreferencesProvider, mapperProvider);
  }

  public static CoinWatchRepositoryImpl newInstance(SharedPreferences sharedPreferences,
      CoinWatchMapper mapper) {
    return new CoinWatchRepositoryImpl(sharedPreferences, mapper);
  }
}
