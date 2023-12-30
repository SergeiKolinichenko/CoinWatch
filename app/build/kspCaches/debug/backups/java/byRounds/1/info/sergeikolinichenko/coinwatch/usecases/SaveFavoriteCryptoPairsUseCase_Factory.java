package info.sergeikolinichenko.coinwatch.usecases;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository;
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
public final class SaveFavoriteCryptoPairsUseCase_Factory implements Factory<SaveFavoriteCryptoPairsUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public SaveFavoriteCryptoPairsUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SaveFavoriteCryptoPairsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SaveFavoriteCryptoPairsUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new SaveFavoriteCryptoPairsUseCase_Factory(repositoryProvider);
  }

  public static SaveFavoriteCryptoPairsUseCase newInstance(CoinWatchRepository repository) {
    return new SaveFavoriteCryptoPairsUseCase(repository);
  }
}
