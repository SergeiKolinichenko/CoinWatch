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
public final class GetMixCoinsListUseCase_Factory implements Factory<GetMixCoinsListUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public GetMixCoinsListUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetMixCoinsListUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetMixCoinsListUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new GetMixCoinsListUseCase_Factory(repositoryProvider);
  }

  public static GetMixCoinsListUseCase newInstance(CoinWatchRepository repository) {
    return new GetMixCoinsListUseCase(repository);
  }
}
