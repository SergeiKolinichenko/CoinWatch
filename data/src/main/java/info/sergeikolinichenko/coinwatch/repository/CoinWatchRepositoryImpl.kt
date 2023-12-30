package info.sergeikolinichenko.coinwatch.repository

import android.content.SharedPreferences
import com.google.gson.JsonArray
import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.models.CoinPairPrice
import info.sergeikolinichenko.coinwatch.models.DetailFiatCoin
import info.sergeikolinichenko.coinwatch.network.ApiFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 07.10.2023 at 18:34 (GMT+3) **/

class CoinWatchRepositoryImpl @Inject constructor(
  private val sharedPreferences: SharedPreferences,
  private val mapper: CoinWatchMapper
) : CoinWatchRepository {

  private var listDetailFiatCoins = mutableListOf<DetailFiatCoin>()
  private var listCryptoCoinNames = mutableListOf<CoinName>()
  private var listFiatCoinNames = mutableListOf<CoinName>()

  override fun saveFavoriteCryptoPairs(set: Set<String>?) {
    sharedPreferences.edit().putStringSet(FAVORITE_CRYPTO_PAIRS, set).apply()
  }
  override fun saveFavoriteFiatPairs(set: Set<String>?) {
    sharedPreferences.edit().putStringSet(FAVORITE_FIAT_PAIRS, set).apply()
  }
  override fun getFavoriteCryptoPairs(): Set<String>? {
    return sharedPreferences.getStringSet(FAVORITE_CRYPTO_PAIRS, null)
  }
  override fun getFavoriteFiatPairs(): Set<String>? {
    return sharedPreferences.getStringSet(FAVORITE_FIAT_PAIRS, null)
  }

  override suspend fun getCryptoPair(
    fromSymbol: String?,
    toSymbols: String?
  ): List<String>? {
    val pair = ApiFactory.getCryptoApi().getCryptoSingleCoinValue(
      fSym = fromSymbol,
      tSyms = toSymbols
    )
    return mapper.mapJsonObjectToCostInt(pair)
  }

  override suspend fun getMixCoinsList(): List<CoinName> {
    if (listFiatCoinNames.isEmpty()) getListFiatCoinNames()
    if (listCryptoCoinNames.isEmpty()) getListCryptoCoinNames()
    return listCryptoCoinNames + listFiatCoinNames
  }

  override suspend fun getCryptoCoinsList(): List<CoinName> {
    if (listCryptoCoinNames.isEmpty()) getListCryptoCoinNames()
    return listCryptoCoinNames
  }

  override suspend fun getFiatCoinsList(): List<CoinName> {
    if (listFiatCoinNames.isEmpty()) getListFiatCoinNames()
    return listFiatCoinNames
  }


  override fun getFavoriteCoinPairsList(): Flow<List<CoinPairPrice>> = flow {
    val fiatPairs = getFiatPairs()
    val cryptoPairs = getCryptoPairs()
    emit(fiatPairs)
  }

  private suspend fun getFiatPairs(): List<CoinPairPrice>
  {
    val list = mutableListOf<CoinPairPrice>()
    val setStrings = getFavoriteFiatPairs()
    for (item in setStrings!!) {
      val fromSymbol = item.substringBefore(",")
      val toSymbol = item.substringAfter(",")
      val pair = getFiatPair(fromSymbol = fromSymbol, toSymbol = toSymbol)
      if (pair != null) list.add(pair)
    }

//    val jsonObject = ApiFactory.getFiatApi().getFiatCoinsValue(
//      apiId = FIAT_PARAM_API_KEY
//    )
//    if (listDetailFiatCoins.isEmpty()) getListFiatDetails()
//    val result = mapper.mapJsonObjectToListFiatCoinsValue(
//      jsonContainer = jsonObject,
//      listDetailFiatCoin = listDetailFiatCoins
//    )
//    Log.d("MyLog", "result: $result")
    return list
  }

  private suspend fun getFiatPair(fromSymbol: String, toSymbol: String?): CoinPairPrice? {
    val jsonObject = ApiFactory.getFiatApi().getFiatCoinsValue(
      apiId = FIAT_PARAM_API_KEY,
      baseSym = fromSymbol,
      toSymbols = toSymbol
    )
    if (listDetailFiatCoins.isEmpty()) getListFiatDetails()
    return mapper.mapJsonObjectToFiatCoinsValue(
      jsonContainer = jsonObject,
      listDetailFiatCoin = listDetailFiatCoins
    )
  }

  private suspend fun getCryptoPairs(): List<CoinPairPrice> {

    val setStrings = getFavoriteCryptoPairs()
    val fromSymbols = mapper.mapFromSymbolFromAllSet(setStrings)
    val toSymbols = mapper.mapToSymbolFromAllSet(setStrings)

    val jsonObject = ApiFactory.getCryptoApi().getCryptoMultiCoinsValue(
      fromSymbols = fromSymbols,
      toSymbols = toSymbols
    )

    if (listDetailFiatCoins.isEmpty()) getListFiatDetails()
    if (listCryptoCoinNames.isEmpty()) getListCryptoCoinNames()

    return mapper.mapJsonObjectToListCryptoCoinsValue(
      jsonContainer = jsonObject,
      listCryptoNames = listCryptoCoinNames,
      listFiatCoin = listDetailFiatCoins,
      set = setStrings
    )
  }

  override suspend fun updateCoinsValueList() {
    TODO("Not yet implemented")
  }

  private suspend fun getListFiatCoinNames(): List<CoinName> {

    val jsonObject = ApiFactory.getFiatApi().getAllFiatCoins()
    if (listDetailFiatCoins.isEmpty()) getListFiatDetails()

    jsonObject?.let {
      listFiatCoinNames = mapper.mapJsonObjectToListNameFiatCoins(
        jsonObject,
        listDetailFiatCoins
      ).toMutableList()
    }
    return listFiatCoinNames
  }

  private suspend fun getListCryptoCoinNames(): List<CoinName> {

    val jsonContainer = ApiFactory.getCryptoApi().getCryptoCoinsList()

    val listCryptoCoinNamesDto = mapper.mapJsonContainerToListCryptoCoinNameDto(
      jsonContainer = jsonContainer
    )
    if (listCryptoCoinNames.isEmpty()) listCryptoCoinNames =
      mapper.listCryptoCoinNameDtoToListModel(listCryptoCoinNamesDto).toMutableList()
    return listCryptoCoinNames
  }

  private suspend fun getListFiatDetails(): List<DetailFiatCoin> {
    val jsonArray = ApiFactory.getFiatDetails().getFiatCoinDetails() ?: JsonArray()
    if (listDetailFiatCoins.isEmpty()) listDetailFiatCoins =
      mapper.mapJsonArrayToListFiatDetail(jsonArray).toMutableList()
    return listDetailFiatCoins
  }

  companion object {
    private const val CRYPTO_PARAM_API_KEY =
      "1db2ada3206800fd269e24260408c33d8d3d135879eaf620eba9aa499b248a94"
    const val API_KEY = "e6d987d3ca0cb35f8db52c60d6b6f44f"
    const val FIAT_PARAM_API_KEY = "130c1cbbc9c44f0c9419b93cdaeed5e7"
    private const val FAVORITE_CRYPTO_PAIRS = "favorite_crypto_pairs"
    private const val FAVORITE_FIAT_PAIRS = "favorite_fiat_pairs"
  }

}