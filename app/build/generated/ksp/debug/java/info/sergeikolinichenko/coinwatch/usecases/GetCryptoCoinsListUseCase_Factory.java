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
public final class GetCryptoCoinsListUseCase_Factory implements Factory<GetCryptoCoinsListUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public GetCryptoCoinsListUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCryptoCoinsListUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetCryptoCoinsListUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new GetCryptoCoinsListUseCase_Factory(repositoryProvider);
  }

  public static GetCryptoCoinsListUseCase newInstance(CoinWatchRepository repository) {
    return new GetCryptoCoinsListUseCase(repository);
  }
}
