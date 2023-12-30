package info.sergeikolinichenko.coinwatch.repository;

/**
 * Created by Sergei Kolinichenko on 07.10.2023 at 18:34 (GMT+3)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001)B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ-\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000e0\u0018H\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001aH\u0016J\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ%\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010$\u001a\u00020%2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001aH\u0016J\u0018\u0010\'\u001a\u00020%2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001aH\u0016J\u0011\u0010(\u001a\u00020%H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Linfo/sergeikolinichenko/coinwatch/repository/CoinWatchRepositoryImpl;", "Linfo/sergeikolinichenko/coinwatch/repository/CoinWatchRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "mapper", "Linfo/sergeikolinichenko/coinwatch/repository/CoinWatchMapper;", "(Landroid/content/SharedPreferences;Linfo/sergeikolinichenko/coinwatch/repository/CoinWatchMapper;)V", "listCryptoCoinNames", "", "Linfo/sergeikolinichenko/coinwatch/models/CoinName;", "listDetailFiatCoins", "Linfo/sergeikolinichenko/coinwatch/models/DetailFiatCoin;", "listFiatCoinNames", "getCryptoCoinsList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCryptoPair", "", "fromSymbol", "toSymbols", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCryptoPairs", "Linfo/sergeikolinichenko/coinwatch/models/CoinPairPrice;", "getFavoriteCoinPairsList", "Lkotlinx/coroutines/flow/Flow;", "getFavoriteCryptoPairs", "", "getFavoriteFiatPairs", "getFiatCoinsList", "getFiatPair", "toSymbol", "getFiatPairs", "getListCryptoCoinNames", "getListFiatCoinNames", "getListFiatDetails", "getMixCoinsList", "saveFavoriteCryptoPairs", "", "set", "saveFavoriteFiatPairs", "updateCoinsValueList", "Companion", "data_debug"})
public final class CoinWatchRepositoryImpl implements info.sergeikolinichenko.coinwatch.repository.CoinWatchRepository {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull
    private final info.sergeikolinichenko.coinwatch.repository.CoinWatchMapper mapper = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<info.sergeikolinichenko.coinwatch.models.DetailFiatCoin> listDetailFiatCoins;
    @org.jetbrains.annotations.NotNull
    private java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName> listCryptoCoinNames;
    @org.jetbrains.annotations.NotNull
    private java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName> listFiatCoinNames;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CRYPTO_PARAM_API_KEY = "1db2ada3206800fd269e24260408c33d8d3d135879eaf620eba9aa499b248a94";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String API_KEY = "e6d987d3ca0cb35f8db52c60d6b6f44f";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FIAT_PARAM_API_KEY = "130c1cbbc9c44f0c9419b93cdaeed5e7";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FAVORITE_CRYPTO_PAIRS = "favorite_crypto_pairs";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String FAVORITE_FIAT_PAIRS = "favorite_fiat_pairs";
    @org.jetbrains.annotations.NotNull
    public static final info.sergeikolinichenko.coinwatch.repository.CoinWatchRepositoryImpl.Companion Companion = null;
    
    @javax.inject.Inject
    public CoinWatchRepositoryImpl(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull
    info.sergeikolinichenko.coinwatch.repository.CoinWatchMapper mapper) {
        super();
    }
    
    @java.lang.Override
    public void saveFavoriteCryptoPairs(@org.jetbrains.annotations.Nullable
    java.util.Set<java.lang.String> set) {
    }
    
    @java.lang.Override
    public void saveFavoriteFiatPairs(@org.jetbrains.annotations.Nullable
    java.util.Set<java.lang.String> set) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.util.Set<java.lang.String> getFavoriteCryptoPairs() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.util.Set<java.lang.String> getFavoriteFiatPairs() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getCryptoPair(@org.jetbrains.annotations.Nullable
    java.lang.String fromSymbol, @org.jetbrains.annotations.Nullable
    java.lang.String toSymbols, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMixCoinsList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getCryptoCoinsList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getFiatCoinsList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice>> getFavoriteCoinPairsList() {
        return null;
    }
    
    private final java.lang.Object getFiatPairs(kotlin.coroutines.Continuation<? super java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice>> $completion) {
        return null;
    }
    
    private final java.lang.Object getFiatPair(java.lang.String fromSymbol, java.lang.String toSymbol, kotlin.coroutines.Continuation<? super info.sergeikolinichenko.coinwatch.models.CoinPairPrice> $completion) {
        return null;
    }
    
    private final java.lang.Object getCryptoPairs(kotlin.coroutines.Continuation<? super java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateCoinsValueList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object getListFiatCoinNames(kotlin.coroutines.Continuation<? super java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName>> $completion) {
        return null;
    }
    
    private final java.lang.Object getListCryptoCoinNames(kotlin.coroutines.Continuation<? super java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName>> $completion) {
        return null;
    }
    
    private final java.lang.Object getListFiatDetails(kotlin.coroutines.Continuation<? super java.util.List<info.sergeikolinichenko.coinwatch.models.DetailFiatCoin>> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Linfo/sergeikolinichenko/coinwatch/repository/CoinWatchRepositoryImpl$Companion;", "", "()V", "API_KEY", "", "CRYPTO_PARAM_API_KEY", "FAVORITE_CRYPTO_PAIRS", "FAVORITE_FIAT_PAIRS", "FIAT_PARAM_API_KEY", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}