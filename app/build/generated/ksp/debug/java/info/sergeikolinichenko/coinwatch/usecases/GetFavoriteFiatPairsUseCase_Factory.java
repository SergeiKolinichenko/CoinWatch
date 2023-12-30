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
public final class GetFavoriteFiatPairsUseCase_Factory implements Factory<GetFavoriteFiatPairsUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public GetFavoriteFiatPairsUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetFavoriteFiatPairsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetFavoriteFiatPairsUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new GetFavoriteFiatPairsUseCase_Factory(repositoryProvider);
  }

  public static GetFavoriteFiatPairsUseCase newInstance(CoinWatchRepository repository) {
    return new GetFavoriteFiatPairsUseCase(repository);
  }
}
