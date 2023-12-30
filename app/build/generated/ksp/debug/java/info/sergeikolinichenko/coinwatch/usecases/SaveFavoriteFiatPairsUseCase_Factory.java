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
public final class SaveFavoriteFiatPairsUseCase_Factory implements Factory<SaveFavoriteFiatPairsUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public SaveFavoriteFiatPairsUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SaveFavoriteFiatPairsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SaveFavoriteFiatPairsUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new SaveFavoriteFiatPairsUseCase_Factory(repositoryProvider);
  }

  public static SaveFavoriteFiatPairsUseCase newInstance(CoinWatchRepository repository) {
    return new SaveFavoriteFiatPairsUseCase(repository);
  }
}
