package info.sergeikolinichenko.coinwatch.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import info.sergeikolinichenko.coinwatch.repository.CoinWatchMapper_Factory;
import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository;
import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepositoryImpl;
import info.sergeikolinichenko.coinwatch.repository.CoinWatchRepositoryImpl_Factory;
import info.sergeikolinichenko.coinwatch.ui.MainActivity;
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.CryptoCoinsViewModel;
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.CryptoCoinsViewModel_Factory;
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.FavoriteCoinPairsViewModel;
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.FavoriteCoinPairsViewModel_Factory;
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.FiatCoinsViewModel;
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.FiatCoinsViewModel_Factory;
import info.sergeikolinichenko.coinwatch.usecases.GetCryptoCoinsListUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetCryptoCoinsListUseCase_Factory;
import info.sergeikolinichenko.coinwatch.usecases.GetCryptoPairUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetCryptoPairUseCase_Factory;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCoinPairsListUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCoinPairsListUseCase_Factory;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCryptoPairsUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteCryptoPairsUseCase_Factory;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteFiatPairsUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetFavoriteFiatPairsUseCase_Factory;
import info.sergeikolinichenko.coinwatch.usecases.GetFiatCoinsListUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetFiatCoinsListUseCase_Factory;
import info.sergeikolinichenko.coinwatch.usecases.GetMixCoinsListUseCase;
import info.sergeikolinichenko.coinwatch.usecases.GetMixCoinsListUseCase_Factory;
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteCryptoPairsUseCase;
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteCryptoPairsUseCase_Factory;
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteFiatPairsUseCase;
import info.sergeikolinichenko.coinwatch.usecases.SaveFavoriteFiatPairsUseCase_Factory;
import info.sergeikolinichenko.coinwatch.utils.ViewModelsFactory;
import info.sergeikolinichenko.coinwatch.utils.ViewModelsFactory_Factory;
import java.util.Map;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DaggerApplicationComponent {
  private DaggerApplicationComponent() {
  }

  public static ApplicationComponent.Factory factory() {
    return new Factory();
  }

  private static final class Factory implements ApplicationComponent.Factory {
    @Override
    public ApplicationComponent create(Application application) {
      Preconditions.checkNotNull(application);
      return new ApplicationComponentImpl(application);
    }
  }

  private static final class ApplicationComponentImpl implements ApplicationComponent {
    private final ApplicationComponentImpl applicationComponentImpl = this;

    private Provider<Application> applicationProvider;

    private Provider<SharedPreferences> provideSharedPreferencesProvider;

    private Provider<CoinWatchRepositoryImpl> coinWatchRepositoryImplProvider;

    private Provider<CoinWatchRepository> bindRepositoryProvider;

    private Provider<GetFavoriteCoinPairsListUseCase> getFavoriteCoinPairsListUseCaseProvider;

    private Provider<GetFavoriteCryptoPairsUseCase> getFavoriteCryptoPairsUseCaseProvider;

    private Provider<SaveFavoriteCryptoPairsUseCase> saveFavoriteCryptoPairsUseCaseProvider;

    private Provider<FavoriteCoinPairsViewModel> favoriteCoinPairsViewModelProvider;

    private Provider<GetCryptoCoinsListUseCase> getCryptoCoinsListUseCaseProvider;

    private Provider<GetMixCoinsListUseCase> getMixCoinsListUseCaseProvider;

    private Provider<GetCryptoPairUseCase> getCryptoPairUseCaseProvider;

    private Provider<Resources> provideRecoursesProvider;

    private Provider<CryptoCoinsViewModel> cryptoCoinsViewModelProvider;

    private Provider<GetFavoriteFiatPairsUseCase> getFavoriteFiatPairsUseCaseProvider;

    private Provider<SaveFavoriteFiatPairsUseCase> saveFavoriteFiatPairsUseCaseProvider;

    private Provider<GetFiatCoinsListUseCase> getFiatCoinsListUseCaseProvider;

    private Provider<FiatCoinsViewModel> fiatCoinsViewModelProvider;

    private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;

    private Provider<ViewModelsFactory> viewModelsFactoryProvider;

    private ApplicationComponentImpl(Application applicationParam) {

      initialize(applicationParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final Application applicationParam) {
      this.applicationProvider = InstanceFactory.create(applicationParam);
      this.provideSharedPreferencesProvider = DoubleCheck.provider(DataModule_Companion_ProvideSharedPreferencesFactory.create(applicationProvider));
      this.coinWatchRepositoryImplProvider = CoinWatchRepositoryImpl_Factory.create(provideSharedPreferencesProvider, CoinWatchMapper_Factory.create());
      this.bindRepositoryProvider = DoubleCheck.provider((Provider) coinWatchRepositoryImplProvider);
      this.getFavoriteCoinPairsListUseCaseProvider = GetFavoriteCoinPairsListUseCase_Factory.create(bindRepositoryProvider);
      this.getFavoriteCryptoPairsUseCaseProvider = GetFavoriteCryptoPairsUseCase_Factory.create(bindRepositoryProvider);
      this.saveFavoriteCryptoPairsUseCaseProvider = SaveFavoriteCryptoPairsUseCase_Factory.create(bindRepositoryProvider);
      this.favoriteCoinPairsViewModelProvider = FavoriteCoinPairsViewModel_Factory.create(getFavoriteCoinPairsListUseCaseProvider, getFavoriteCryptoPairsUseCaseProvider, saveFavoriteCryptoPairsUseCaseProvider);
      this.getCryptoCoinsListUseCaseProvider = GetCryptoCoinsListUseCase_Factory.create(bindRepositoryProvider);
      this.getMixCoinsListUseCaseProvider = GetMixCoinsListUseCase_Factory.create(bindRepositoryProvider);
      this.getCryptoPairUseCaseProvider = GetCryptoPairUseCase_Factory.create(bindRepositoryProvider);
      this.provideRecoursesProvider = DoubleCheck.provider(ViewModelsModule_Companion_ProvideRecoursesFactory.create(applicationProvider));
      this.cryptoCoinsViewModelProvider = CryptoCoinsViewModel_Factory.create(getFavoriteCryptoPairsUseCaseProvider, getCryptoCoinsListUseCaseProvider, getMixCoinsListUseCaseProvider, getCryptoPairUseCaseProvider, saveFavoriteCryptoPairsUseCaseProvider, provideRecoursesProvider);
      this.getFavoriteFiatPairsUseCaseProvider = GetFavoriteFiatPairsUseCase_Factory.create(bindRepositoryProvider);
      this.saveFavoriteFiatPairsUseCaseProvider = SaveFavoriteFiatPairsUseCase_Factory.create(bindRepositoryProvider);
      this.getFiatCoinsListUseCaseProvider = GetFiatCoinsListUseCase_Factory.create(bindRepositoryProvider);
      this.fiatCoinsViewModelProvider = FiatCoinsViewModel_Factory.create(getFavoriteFiatPairsUseCaseProvider, saveFavoriteFiatPairsUseCaseProvider, getFiatCoinsListUseCaseProvider, provideRecoursesProvider);
      this.mapOfClassOfAndProviderOfViewModelProvider = MapProviderFactory.<Class<? extends ViewModel>, ViewModel>builder(3).put(FavoriteCoinPairsViewModel.class, ((Provider) favoriteCoinPairsViewModelProvider)).put(CryptoCoinsViewModel.class, ((Provider) cryptoCoinsViewModelProvider)).put(FiatCoinsViewModel.class, ((Provider) fiatCoinsViewModelProvider)).build();
      this.viewModelsFactoryProvider = DoubleCheck.provider(ViewModelsFactory_Factory.create(mapOfClassOfAndProviderOfViewModelProvider));
    }

    @Override
    public void inject(MainActivity activity) {
    }

    @Override
    public ViewModelsFactory getViewModelsFactory() {
      return viewModelsFactoryProvider.get();
    }
  }
}
