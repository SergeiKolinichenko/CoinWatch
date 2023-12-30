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
public final class GetFavoriteCoinPairsListUseCase_Factory implements Factory<GetFavoriteCoinPairsListUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public GetFavoriteCoinPairsListUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetFavoriteCoinPairsListUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetFavoriteCoinPairsListUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new GetFavoriteCoinPairsListUseCase_Factory(repositoryProvider);
  }

  public static GetFavoriteCoinPairsListUseCase newInstance(CoinWatchRepository repository) {
    return new GetFavoriteCoinPairsListUseCase(repository);
  }
}
