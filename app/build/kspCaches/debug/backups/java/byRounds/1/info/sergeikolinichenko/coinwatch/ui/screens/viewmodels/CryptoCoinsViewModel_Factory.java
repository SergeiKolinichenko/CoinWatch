package info.sergeikolinichenko.coinwatch.ui.screens.viewmodels;

import android.content.res.Resources;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import info.sergeikolinichenko.coinwatch.usecases.GetCryptoCoinsListUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetCryptoPairUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCryptoPairsUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetMixCoinsListUseCase;
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteCryptoPairsUseCase;
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
public final class CryptoCoinsViewModel_Factory implements Factory<CryptoCoinsViewModel> {
  private final Provider<GetFavoriteCryptoPairsUseCase> getFavoriteCryptoPairsUseCaseProvider;

  private final Provider<GetCryptoCoinsListUseCase> getCryptoCoinsListProvider;

  private final Provider<GetMixCoinsListUseCase> getMixCoinsListProvider;

  private final Provider<GetCryptoPairUseCase> getCryptoPairProvider;

  private final Provider<SaveFavoriteCryptoPairsUseCase> saveFavoriteCryptoPairsProvider;

  private final Provider<Resources> resourcesProvider;

  public CryptoCoinsViewModel_Factory(
      Provider<GetFavoriteCryptoPairsUseCase> getFavoriteCryptoPairsUseCaseProvider,
      Provider<GetCryptoCoinsListUseCase> getCryptoCoinsListProvider,
      Provider<GetMixCoinsListUseCase> getMixCoinsListProvider,
      Provider<GetCryptoPairUseCase> getCryptoPairProvider,
      Provider<SaveFavoriteCryptoPairsUseCase> saveFavoriteCryptoPairsProvider,
      Provider<Resources> resourcesProvider) {
    this.getFavoriteCryptoPairsUseCaseProvider = getFavoriteCryptoPairsUseCaseProvider;
    this.getCryptoCoinsListProvider = getCryptoCoinsListProvider;
    this.getMixCoinsListProvider = getMixCoinsListProvider;
    this.getCryptoPairProvider = getCryptoPairProvider;
    this.saveFavoriteCryptoPairsProvider = saveFavoriteCryptoPairsProvider;
    this.resourcesProvider = resourcesProvider;
  }

  @Override
  public CryptoCoinsViewModel get() {
    return newInstance(getFavoriteCryptoPairsUseCaseProvider.get(), getCryptoCoinsListProvider.get(), getMixCoinsListProvider.get(), getCryptoPairProvider.get(), saveFavoriteCryptoPairsProvider.get(), resourcesProvider.get());
  }

  public static CryptoCoinsViewModel_Factory create(
      Provider<GetFavoriteCryptoPairsUseCase> getFavoriteCryptoPairsUseCaseProvider,
      Provider<GetCryptoCoinsListUseCase> getCryptoCoinsListProvider,
      Provider<GetMixCoinsListUseCase> getMixCoinsListProvider,
      Provider<GetCryptoPairUseCase> getCryptoPairProvider,
      Provider<SaveFavoriteCryptoPairsUseCase> saveFavoriteCryptoPairsProvider,
      Provider<Resources> resourcesProvider) {
    return new CryptoCoinsViewModel_Factory(getFavoriteCryptoPairsUseCaseProvider, getCryptoCoinsListProvider, getMixCoinsListProvider, getCryptoPairProvider, saveFavoriteCryptoPairsProvider, resourcesProvider);
  }

  public static CryptoCoinsViewModel newInstance(
      GetFavoriteCryptoPairsUseCase getFavoriteCryptoPairsUseCase,
      GetCryptoCoinsListUseCase getCryptoCoinsList, GetMixCoinsListUseCase getMixCoinsList,
      GetCryptoPairUseCase getCryptoPair, SaveFavoriteCryptoPairsUseCase saveFavoriteCryptoPairs,
      Resources resources) {
    return new CryptoCoinsViewModel(getFavoriteCryptoPairsUseCase, getCryptoCoinsList, getMixCoinsList, getCryptoPair, saveFavoriteCryptoPairs, resources);
  }
}
