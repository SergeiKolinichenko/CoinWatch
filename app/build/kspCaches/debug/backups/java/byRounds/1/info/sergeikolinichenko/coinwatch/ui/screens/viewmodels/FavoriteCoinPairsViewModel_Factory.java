package info.sergeikolinichenko.coinwatch.ui.screens.viewmodels;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCoinPairsListUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCryptoPairsUseCase;
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
public final class FavoriteCoinPairsViewModel_Factory implements Factory<FavoriteCoinPairsViewModel> {
  private final Provider<GetFavoriteCoinPairsListUseCase> getCoinPairsListProvider;

  private final Provider<GetFavoriteCryptoPairsUseCase> loadFavoriteCoinPairsProvider;

  private final Provider<SaveFavoriteCryptoPairsUseCase> saveFavoriteCoinPairsProvider;

  public FavoriteCoinPairsViewModel_Factory(
      Provider<GetFavoriteCoinPairsListUseCase> getCoinPairsListProvider,
      Provider<GetFavoriteCryptoPairsUseCase> loadFavoriteCoinPairsProvider,
      Provider<SaveFavoriteCryptoPairsUseCase> saveFavoriteCoinPairsProvider) {
    this.getCoinPairsListProvider = getCoinPairsListProvider;
    this.loadFavoriteCoinPairsProvider = loadFavoriteCoinPairsProvider;
    this.saveFavoriteCoinPairsProvider = saveFavoriteCoinPairsProvider;
  }

  @Override
  public FavoriteCoinPairsViewModel get() {
    return newInstance(getCoinPairsListProvider.get(), loadFavoriteCoinPairsProvider.get(), saveFavoriteCoinPairsProvider.get());
  }

  public static FavoriteCoinPairsViewModel_Factory create(
      Provider<GetFavoriteCoinPairsListUseCase> getCoinPairsListProvider,
      Provider<GetFavoriteCryptoPairsUseCase> loadFavoriteCoinPairsProvider,
      Provider<SaveFavoriteCryptoPairsUseCase> saveFavoriteCoinPairsProvider) {
    return new FavoriteCoinPairsViewModel_Factory(getCoinPairsListProvider, loadFavoriteCoinPairsProvider, saveFavoriteCoinPairsProvider);
  }

  public static FavoriteCoinPairsViewModel newInstance(
      GetFavoriteCoinPairsListUseCase getCoinPairsList,
      GetFavoriteCryptoPairsUseCase loadFavoriteCoinPairs,
      SaveFavoriteCryptoPairsUseCase saveFavoriteCoinPairs) {
    return new FavoriteCoinPairsViewModel(getCoinPairsList, loadFavoriteCoinPairs, saveFavoriteCoinPairs);
  }
}
