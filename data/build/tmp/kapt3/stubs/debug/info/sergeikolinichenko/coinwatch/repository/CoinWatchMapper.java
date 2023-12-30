package info.sergeikolinichenko.coinwatch.repository;

/**
 * Created by Sergei Kolinichenko on 08.10.2023 at 18:07 (GMT+3)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0002J8\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J.\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J\u0018\u0010\"\u001a\u0004\u0018\u00010!2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010$\u001a\u00020%J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\'\u001a\u00020(J\u0018\u0010)\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J \u0010*\u001a\u0004\u0018\u00010\b2\b\u0010\'\u001a\u0004\u0018\u00010+2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\'\u001a\u00020+H\u0002J@\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\'\u001a\u00020/2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 J\"\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007J\u0018\u00102\u001a\u0004\u0018\u00010!2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Linfo/sergeikolinichenko/coinwatch/repository/CoinWatchMapper;", "", "()V", "moshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "addFromSymbImgCoinPairPrice", "", "Linfo/sergeikolinichenko/coinwatch/models/CoinPairPrice;", "listCryptoPairPrice", "listDetailFiatCoin", "Linfo/sergeikolinichenko/coinwatch/models/DetailFiatCoin;", "addToSymImgCoinPairPrice", "listCoinPairsPrice", "listCryptoNames", "Linfo/sergeikolinichenko/coinwatch/models/CoinName;", "coinPairsPriceRowDtoToModel", "coin", "Linfo/sergeikolinichenko/coinwatch/models/dto/CryptoPairPriceDto;", "cryptoCoinNameDtoToModel", "elementDto", "Linfo/sergeikolinichenko/coinwatch/models/dto/CryptoCoinNameDto;", "jsonObjectToListCoinPairPrice", "jsonObject", "Lcom/google/gson/JsonObject;", "listCryptoCoinNameDtoToListModel", "listDto", "mapDetailFiatCoinDtoToModel", "detailDto", "Linfo/sergeikolinichenko/coinwatch/models/dto/DetailFiatCoinDto;", "mapFromAllCoinPairsToFavoritePairs", "set", "", "", "mapFromSymbolFromAllSet", "mapJsonArrayToListFiatDetail", "jsonArray", "Lcom/google/gson/JsonArray;", "mapJsonContainerToListCryptoCoinNameDto", "jsonContainer", "Linfo/sergeikolinichenko/coinwatch/models/dto/CoinNamesContainerDto;", "mapJsonObjectToCostInt", "mapJsonObjectToFiatCoinsValue", "Linfo/sergeikolinichenko/coinwatch/models/dto/FiatPairPriceContainerDto;", "mapJsonObjectToFiatCoinsValueDto", "Linfo/sergeikolinichenko/coinwatch/models/dto/FiatPairPriceDto;", "mapJsonObjectToListCryptoCoinsValue", "Linfo/sergeikolinichenko/coinwatch/models/dto/CryptoPairPriceContainerDto;", "listFiatCoin", "mapJsonObjectToListNameFiatCoins", "mapToSymbolFromAllSet", "data_debug"})
public final class CoinWatchMapper {
    private final com.squareup.moshi.Moshi moshi = null;
    
    @javax.inject.Inject
    public CoinWatchMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName> listCryptoCoinNameDtoToListModel(@org.jetbrains.annotations.NotNull
    java.util.List<info.sergeikolinichenko.coinwatch.models.dto.CryptoCoinNameDto> listDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<info.sergeikolinichenko.coinwatch.models.dto.CryptoCoinNameDto> mapJsonContainerToListCryptoCoinNameDto(@org.jetbrains.annotations.NotNull
    info.sergeikolinichenko.coinwatch.models.dto.CoinNamesContainerDto jsonContainer) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> mapJsonObjectToCostInt(@org.jetbrains.annotations.Nullable
    com.google.gson.JsonObject jsonObject) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName> mapJsonObjectToListNameFiatCoins(@org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject jsonObject, @org.jetbrains.annotations.NotNull
    java.util.List<info.sergeikolinichenko.coinwatch.models.DetailFiatCoin> listDetailFiatCoin) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<info.sergeikolinichenko.coinwatch.models.DetailFiatCoin> mapJsonArrayToListFiatDetail(@org.jetbrains.annotations.NotNull
    com.google.gson.JsonArray jsonArray) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice> mapJsonObjectToListCryptoCoinsValue(@org.jetbrains.annotations.NotNull
    info.sergeikolinichenko.coinwatch.models.dto.CryptoPairPriceContainerDto jsonContainer, @org.jetbrains.annotations.NotNull
    java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName> listCryptoNames, @org.jetbrains.annotations.NotNull
    java.util.List<info.sergeikolinichenko.coinwatch.models.DetailFiatCoin> listFiatCoin, @org.jetbrains.annotations.Nullable
    java.util.Set<java.lang.String> set) {
        return null;
    }
    
    private final java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice> jsonObjectToListCoinPairPrice(com.google.gson.JsonObject jsonObject) {
        return null;
    }
    
    private final java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice> mapFromAllCoinPairsToFavoritePairs(java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice> listCryptoPairPrice, java.util.Set<java.lang.String> set) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String mapFromSymbolFromAllSet(@org.jetbrains.annotations.Nullable
    java.util.Set<java.lang.String> set) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String mapToSymbolFromAllSet(@org.jetbrains.annotations.Nullable
    java.util.Set<java.lang.String> set) {
        return null;
    }
    
    private final info.sergeikolinichenko.coinwatch.models.DetailFiatCoin mapDetailFiatCoinDtoToModel(info.sergeikolinichenko.coinwatch.models.dto.DetailFiatCoinDto detailDto) {
        return null;
    }
    
    private final java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice> addToSymImgCoinPairPrice(java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice> listCoinPairsPrice, java.util.List<info.sergeikolinichenko.coinwatch.models.DetailFiatCoin> listDetailFiatCoin, java.util.List<info.sergeikolinichenko.coinwatch.models.CoinName> listCryptoNames) {
        return null;
    }
    
    private final java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice> addFromSymbImgCoinPairPrice(java.util.List<info.sergeikolinichenko.coinwatch.models.CoinPairPrice> listCryptoPairPrice, java.util.List<info.sergeikolinichenko.coinwatch.models.DetailFiatCoin> listDetailFiatCoin) {
        return null;
    }
    
    private final info.sergeikolinichenko.coinwatch.models.CoinPairPrice coinPairsPriceRowDtoToModel(info.sergeikolinichenko.coinwatch.models.dto.CryptoPairPriceDto coin) {
        return null;
    }
    
    private final info.sergeikolinichenko.coinwatch.models.CoinName cryptoCoinNameDtoToModel(info.sergeikolinichenko.coinwatch.models.dto.CryptoCoinNameDto elementDto) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final info.sergeikolinichenko.coinwatch.models.CoinPairPrice mapJsonObjectToFiatCoinsValue(@org.jetbrains.annotations.Nullable
    info.sergeikolinichenko.coinwatch.models.dto.FiatPairPriceContainerDto jsonContainer, @org.jetbrains.annotations.NotNull
    java.util.List<info.sergeikolinichenko.coinwatch.models.DetailFiatCoin> listDetailFiatCoin) {
        return null;
    }
    
    private final info.sergeikolinichenko.coinwatch.models.dto.FiatPairPriceDto mapJsonObjectToFiatCoinsValueDto(info.sergeikolinichenko.coinwatch.models.dto.FiatPairPriceContainerDto jsonContainer) {
        return null;
    }
}