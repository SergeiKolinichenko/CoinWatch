package info.sergeikolinichenko.coinwatch.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class CoinWatchMapper_Factory implements Factory<CoinWatchMapper> {
  @Override
  public CoinWatchMapper get() {
    return newInstance();
  }

  public static CoinWatchMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoinWatchMapper newInstance() {
    return new CoinWatchMapper();
  }

  private static final class InstanceHolder {
    private static final CoinWatchMapper_Factory INSTANCE = new CoinWatchMapper_Factory();
  }
}
