package info.sergeikolinichenko.coinwatch.network;

/**
 * Created by Sergei Kolinichenko on 07.10.2023 at 17:34 (GMT+3)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Linfo/sergeikolinichenko/coinwatch/network/ApiFactory;", "", "()V", "CRYPTO_BASE_URL", "", "CRYPTO_IMAGE_URL", "EXCHANGERATE_BASE_URL", "FIAT_BASE_URL", "FIAT_DETAILS", "okHttpClient", "Lokhttp3/OkHttpClient$Builder;", "getCryptoApi", "Linfo/sergeikolinichenko/coinwatch/network/ApiService;", "getExchangeRateApi", "getFiatApi", "getFiatDetails", "data_debug"})
public final class ApiFactory {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CRYPTO_BASE_URL = "https://min-api.cryptocompare.com/data/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CRYPTO_IMAGE_URL = "https://cryptocompare.com";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FIAT_BASE_URL = "https://openexchangerates.org/api/";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EXCHANGERATE_BASE_URL = "https://v6.exchangerate-api.com/v6/";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FIAT_DETAILS = "https://gist.githubusercontent.com/manishtiwari25/d3984385b1cb200b98bcde6902671599/raw/b5bc497e9f26f95cda2e32bbd40ff3da4a494cff/";
    @org.jetbrains.annotations.NotNull
    private static final okhttp3.OkHttpClient.Builder okHttpClient = null;
    @org.jetbrains.annotations.NotNull
    public static final info.sergeikolinichenko.coinwatch.network.ApiFactory INSTANCE = null;
    
    private ApiFactory() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final info.sergeikolinichenko.coinwatch.network.ApiService getCryptoApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final info.sergeikolinichenko.coinwatch.network.ApiService getFiatApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final info.sergeikolinichenko.coinwatch.network.ApiService getExchangeRateApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final info.sergeikolinichenko.coinwatch.network.ApiService getFiatDetails() {
        return null;
    }
}