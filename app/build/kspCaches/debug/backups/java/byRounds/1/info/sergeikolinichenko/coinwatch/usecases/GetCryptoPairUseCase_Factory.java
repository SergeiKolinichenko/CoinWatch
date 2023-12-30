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
public final class GetCryptoPairUseCase_Factory implements Factory<GetCryptoPairUseCase> {
  private final Provider<CoinWatchRepository> repositoryProvider;

  public GetCryptoPairUseCase_Factory(Provider<CoinWatchRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCryptoPairUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetCryptoPairUseCase_Factory create(
      Provider<CoinWatchRepository> repositoryProvider) {
    return new GetCryptoPairUseCase_Factory(repositoryProvider);
  }

  public static GetCryptoPairUseCase newInstance(CoinWatchRepository repository) {
    return new GetCryptoPairUseCase(repository);
  }
}
