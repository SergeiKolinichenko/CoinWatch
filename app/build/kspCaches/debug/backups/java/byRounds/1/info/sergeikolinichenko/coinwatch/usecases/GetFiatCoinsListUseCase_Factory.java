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
public final class GetFiatCoinsListUseCase_Factory implements Factory<GetFiatCoinsListUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public GetFiatCoinsListUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetFiatCoinsListUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetFiatCoinsListUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new GetFiatCoinsListUseCase_Factory(repositoryProvider);
  }

  public static GetFiatCoinsListUseCase newInstance(CoinWatchRepository repository) {
    return new GetFiatCoinsListUseCase(repository);
  }
}
