package info.sergeikolinichenko.coinwatch.network;

/**
 * Created by Sergei Kolinichenko on 07.10.2023 at 17:36 (GMT+3)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ3\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ5\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J5\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0003\u0010\u0016\u001a\u00020\b2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Linfo/sergeikolinichenko/coinwatch/network/ApiService;", "", "getAllFiatCoins", "Lcom/google/gson/JsonObject;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCryptoCoinsList", "Linfo/sergeikolinichenko/coinwatch/models/dto/CoinNamesContainerDto;", "apiKey", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCryptoMultiCoinsValue", "Linfo/sergeikolinichenko/coinwatch/models/dto/CryptoPairPriceContainerDto;", "fromSymbols", "toSymbols", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCryptoSingleCoinValue", "fSym", "tSyms", "getFiatCoinDetails", "Lcom/google/gson/JsonArray;", "getFiatCoinsValue", "Linfo/sergeikolinichenko/coinwatch/models/dto/FiatPairPriceContainerDto;", "apiId", "baseSym", "Companion", "data_debug"})
public abstract interface ApiService {
    @org.jetbrains.annotations.NotNull
    public static final info.sergeikolinichenko.coinwatch.network.ApiService.Companion Companion = null;
    
    @retrofit2.http.GET(value = "all/coinlist?summary=true")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCryptoCoinsList(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super info.sergeikolinichenko.coinwatch.models.dto.CoinNamesContainerDto> $completion);
    
    @retrofit2.http.GET(value = "pricemultifull")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCryptoMultiCoinsValue(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Query(value = "fsyms")
    @org.jetbrains.annotations.Nullable
    java.lang.String fromSymbols, @retrofit2.http.Query(value = "tsyms")
    @org.jetbrains.annotations.Nullable
    java.lang.String toSymbols, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super info.sergeikolinichenko.coinwatch.models.dto.CryptoPairPriceContainerDto> $completion);
    
    @retrofit2.http.GET(value = "price")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCryptoSingleCoinValue(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Query(value = "fsym")
    @org.jetbrains.annotations.Nullable
    java.lang.String fSym, @retrofit2.http.Query(value = "tsyms")
    @org.jetbrains.annotations.Nullable
    java.lang.String tSyms, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.google.gson.JsonObject> $completion);
    
    @retrofit2.http.GET(value = "currencies.json")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllFiatCoins(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.google.gson.JsonObject> $completion);
    
    @retrofit2.http.GET(value = "latest.json")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFiatCoinsValue(@retrofit2.http.Query(value = "app_id")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiId, @retrofit2.http.Query(value = "base")
    @org.jetbrains.annotations.Nullable
    java.lang.String baseSym, @retrofit2.http.Query(value = "symbols")
    @org.jetbrains.annotations.Nullable
    java.lang.String toSymbols, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super info.sergeikolinichenko.coinwatch.models.dto.FiatPairPriceContainerDto> $completion);
    
    @retrofit2.http.GET(value = "world_currency_symbols.json")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getFiatCoinDetails(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.google.gson.JsonArray> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Linfo/sergeikolinichenko/coinwatch/network/ApiService$Companion;", "", "()V", "CURRENCY_EUR", "", "CURRENCY_USD", "CURRENCY_USDT", "CURRENCY_USDT_BUSD", "CURRENCY_USD_EUR", "QUERY_PARAM_API_KEY", "QUERY_PARAM_APP_ID", "QUERY_PARAM_BASE_SYMBOL", "QUERY_PARAM_FROM_SYMBOL", "QUERY_PARAM_FROM_SYMBOLS", "QUERY_PARAM_SYMBOLS_TO", "QUERY_PARAM_TO_SYMBOLS", "data_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String QUERY_PARAM_API_KEY = "api_key";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String QUERY_PARAM_TO_SYMBOLS = "tsyms";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String QUERY_PARAM_FROM_SYMBOLS = "fsyms";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String QUERY_PARAM_FROM_SYMBOL = "fsym";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String QUERY_PARAM_APP_ID = "app_id";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String QUERY_PARAM_BASE_SYMBOL = "base";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String QUERY_PARAM_SYMBOLS_TO = "symbols";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String CURRENCY_USD = "USD";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String CURRENCY_EUR = "EUR";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String CURRENCY_USD_EUR = "USD,EUR";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String CURRENCY_USDT = "USDT";
        @org.jetbrains.annotations.NotNull
        private static final java.lang.String CURRENCY_USDT_BUSD = "USDT,BUSD";
        
        private Companion() {
            super();
        }
    }
    
    /**
     * Created by Sergei Kolinichenko on 07.10.2023 at 17:36 (GMT+3)
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}