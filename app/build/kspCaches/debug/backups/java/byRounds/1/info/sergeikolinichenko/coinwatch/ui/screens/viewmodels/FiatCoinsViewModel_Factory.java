package info.sergeikolinichenko.coinwatch.ui.screens.viewmodels;

import android.content.res.Resources;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteFiatPairsUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetFiatCoinsListUseCase;
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteFiatPairsUseCase;
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
public final class FiatCoinsViewModel_Factory implements Factory<FiatCoinsViewModel> {
  private final Provider<GetFavoriteFiatPairsUseCase> getFavoriteFiatPairsProvider;

  private final Provider<SaveFavoriteFiatPairsUseCase> saveFavoriteFiatPairsProvider;

  private final Provider<GetFiatCoinsListUseCase> getFiatCoinsListProvider;

  private final Provider<Resources> resourcesProvider;

  public FiatCoinsViewModel_Factory(
      Provider<GetFavoriteFiatPairsUseCase> getFavoriteFiatPairsProvider,
      Provider<SaveFavoriteFiatPairsUseCase> saveFavoriteFiatPairsProvider,
      Provider<GetFiatCoinsListUseCase> getFiatCoinsListProvider,
      Provider<Resources> resourcesProvider) {
    this.getFavoriteFiatPairsProvider = getFavoriteFiatPairsProvider;
    this.saveFavoriteFiatPairsProvider = saveFavoriteFiatPairsProvider;
    this.getFiatCoinsListProvider = getFiatCoinsListProvider;
    this.resourcesProvider = resourcesProvider;
  }

  @Override
  public FiatCoinsViewModel get() {
    return newInstance(getFavoriteFiatPairsProvider.get(), saveFavoriteFiatPairsProvider.get(), getFiatCoinsListProvider.get(), resourcesProvider.get());
  }

  public static FiatCoinsViewModel_Factory create(
      Provider<GetFavoriteFiatPairsUseCase> getFavoriteFiatPairsProvider,
      Provider<SaveFavoriteFiatPairsUseCase> saveFavoriteFiatPairsProvider,
      Provider<GetFiatCoinsListUseCase> getFiatCoinsListProvider,
      Provider<Resources> resourcesProvider) {
    return new FiatCoinsViewModel_Factory(getFavoriteFiatPairsProvider, saveFavoriteFiatPairsProvider, getFiatCoinsListProvider, resourcesProvider);
  }

  public static FiatCoinsViewModel newInstance(GetFavoriteFiatPairsUseCase getFavoriteFiatPairs,
      SaveFavoriteFiatPairsUseCase saveFavoriteFiatPairs, GetFiatCoinsListUseCase getFiatCoinsList,
      Resources resources) {
    return new FiatCoinsViewModel(getFavoriteFiatPairs, saveFavoriteFiatPairs, getFiatCoinsList, resources);
  }
}
