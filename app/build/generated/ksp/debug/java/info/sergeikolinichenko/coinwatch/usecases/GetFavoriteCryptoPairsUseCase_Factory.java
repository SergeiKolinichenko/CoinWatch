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
public final class GetFavoriteCryptoPairsUseCase_Factory implements Factory<GetFavoriteCryptoPairsUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public GetFavoriteCryptoPairsUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetFavoriteCryptoPairsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetFavoriteCryptoPairsUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new GetFavoriteCryptoPairsUseCase_Factory(repositoryProvider);
  }

  public static GetFavoriteCryptoPairsUseCase newInstance(CoinWatchRepository repository) {
    return new GetFavoriteCryptoPairsUseCase(repository);
  }
}
