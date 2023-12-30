package info.sergeikolinichenko.coinwatch.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import info.sergeikolinichenko.coinwatch.models.dto.CoinNamesContainerDto
import info.sergeikolinichenko.coinwatch.models.dto.CryptoPairPriceContainerDto
import info.sergeikolinichenko.coinwatch.models.dto.FiatPairPriceContainerDto
import retrofit2.http.GET
import retrofit2.http.Query

/** Created by Sergei Kolinichenko on 07.10.2023 at 17:36 (GMT+3) **/

interface ApiService {

  // Crypto part

  @GET("all/coinlist?summary=true")
  suspend fun getCryptoCoinsList(
    @Query(QUERY_PARAM_API_KEY) apiKey: String = ""
  ): CoinNamesContainerDto

  @GET("pricemultifull")
  suspend fun getCryptoMultiCoinsValue(
    @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
    @Query(QUERY_PARAM_FROM_SYMBOLS) fromSymbols: String? = CURRENCY_USDT_BUSD,
    @Query(QUERY_PARAM_TO_SYMBOLS) toSymbols: String? = CURRENCY_USD_EUR
  ): CryptoPairPriceContainerDto



  @GET("price")
  suspend fun getCryptoSingleCoinValue(
    @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
    @Query(QUERY_PARAM_FROM_SYMBOL) fSym: String? = CURRENCY_USDT,
    @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String? = CURRENCY_USD
  ): JsonObject?

  // Fiat part
  @GET("currencies.json")
  suspend fun getAllFiatCoins(): JsonObject?
  @GET("latest.json")
  suspend fun getFiatCoinsValue(
    @Query(QUERY_PARAM_APP_ID) apiId: String = "",
    @Query(QUERY_PARAM_BASE_SYMBOL) baseSym: String? = CURRENCY_USD,
    @Query(QUERY_PARAM_SYMBOLS_TO) toSymbols: String? = CURRENCY_EUR
  ): FiatPairPriceContainerDto?

  @GET("world_currency_symbols.json")
  suspend fun getFiatCoinDetails(): JsonArray?

  companion object {
    private const val QUERY_PARAM_API_KEY = "api_key"
    private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
    private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
    private const val QUERY_PARAM_FROM_SYMBOL = "fsym"

    private const val QUERY_PARAM_APP_ID = "app_id"
    private const val QUERY_PARAM_BASE_SYMBOL = "base"
    private const val QUERY_PARAM_SYMBOLS_TO = "symbols"

    private const val CURRENCY_USD = "USD"
    private const val CURRENCY_EUR = "EUR"
    private const val CURRENCY_USD_EUR = "USD,EUR"
    private const val CURRENCY_USDT = "USDT"
    private const val CURRENCY_USDT_BUSD = "USDT,BUSD"
  }
}