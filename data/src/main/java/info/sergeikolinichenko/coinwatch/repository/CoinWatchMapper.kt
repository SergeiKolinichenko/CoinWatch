package info.sergeikolinichenko.coinwatch.repository

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.models.CoinPairPrice
import info.sergeikolinichenko.coinwatch.models.DetailFiatCoin
import info.sergeikolinichenko.coinwatch.models.dto.CoinNamesContainerDto
import info.sergeikolinichenko.coinwatch.models.dto.CryptoCoinNameDto
import info.sergeikolinichenko.coinwatch.models.dto.CryptoPairPriceContainerDto
import info.sergeikolinichenko.coinwatch.models.dto.CryptoPairPriceDto
import info.sergeikolinichenko.coinwatch.models.dto.DetailFiatCoinDto
import info.sergeikolinichenko.coinwatch.models.dto.FiatPairPriceContainerDto
import info.sergeikolinichenko.coinwatch.models.dto.FiatPairPriceDto
import info.sergeikolinichenko.coinwatch.network.ApiFactory.CRYPTO_IMAGE_URL
import info.sergeikolinichenko.coinwatch.utils.ConversionTools.convertTimestampToDate
import info.sergeikolinichenko.coinwatch.utils.ConversionTools.convertTimestampToTime
import info.sergeikolinichenko.coinwatch.utils.ConversionTools.getIntString
import javax.inject.Inject

/** Created by Sergei Kolinichenko on 08.10.2023 at 18:07 (GMT+3) **/


class CoinWatchMapper @Inject constructor() {

  private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

  fun listCryptoCoinNameDtoToListModel(listDto: List<CryptoCoinNameDto>) =
    listDto.map { cryptoCoinNameDtoToModel(it) }

  fun mapJsonContainerToListCryptoCoinNameDto(
    jsonContainer: CoinNamesContainerDto
  ): List<CryptoCoinNameDto> = run {

    return jsonContainer.json?.let { jsonObject ->
      jsonObject.keySet()?.mapNotNull { key ->
        jsonObject.getAsJsonObject(key)?.let { item ->
          moshi.adapter(CryptoCoinNameDto::class.java).fromJson(item.toString())
        }
      }
    } ?: emptyList()

  }

  fun mapJsonObjectToCostInt(jsonObject: JsonObject?): List<String>? = run {

    return jsonObject?.let {
      if (jsonObject.has("Error") || jsonObject.has("Response")) return null
      val result = mutableListOf<String>()
      val keySet = jsonObject.keySet()
      keySet?.forEach { key ->
        val item = jsonObject.getAsJsonPrimitive(key)
        item?.let {
          val price = "$key,$item"
          result.add(price)
        }
      }
      result
    }
  }

  fun mapJsonObjectToListNameFiatCoins(
    jsonObject: JsonObject, listDetailFiatCoin: List<DetailFiatCoin>
  ): List<CoinName> = run {

    return jsonObject.keySet().mapNotNull { key ->
      val detailFiat = listDetailFiatCoin.find { it.fiatCoinCode == key }
      val item = jsonObject.getAsJsonPrimitive(key)
      val coin = detailFiat?.let {
        CoinName(
          coinId = 0,
          coinCode = key,
          coinName = item.toString(),
          coinImgUrl = it.fiatCountryFlag
        )
      }
      coin
    }
  }

  fun mapJsonArrayToListFiatDetail(jsonArray: JsonArray): List<DetailFiatCoin> = run {

    return jsonArray.mapNotNull { element ->
      moshi.adapter(DetailFiatCoinDto::class.java).fromJson(element.toString())?.let { item ->
        mapDetailFiatCoinDtoToModel(item)
      }
    }

  }

  fun mapJsonObjectToListCryptoCoinsValue(
    jsonContainer: CryptoPairPriceContainerDto,
    listCryptoNames: List<CoinName>,
    listFiatCoin: List<DetailFiatCoin>,
    set: Set<String>?
  ): List<CoinPairPrice> {

    return jsonContainer.jsonRow?.let { jsonRow ->
      val resultList = jsonObjectToListCoinPairPrice(jsonRow)
      val resultListWithFlags = addFromSymbImgCoinPairPrice(
        resultList,
        listFiatCoin
      )
      val resultListWithCoinImg = addToSymImgCoinPairPrice(
        resultListWithFlags,
        listFiatCoin,
        listCryptoNames
      )

      mapFromAllCoinPairsToFavoritePairs(
        resultListWithCoinImg, set
      ) ?: resultListWithCoinImg
    } ?: emptyList()
  }

  private fun jsonObjectToListCoinPairPrice(
    jsonObject: JsonObject
  ): List<CoinPairPrice> = run {

    jsonObject.keySet().mapNotNull { keyFrom ->
      val itemFrom = jsonObject.getAsJsonObject(keyFrom)
      itemFrom.keySet()?.mapNotNull { keyTo ->
        val itemTo = itemFrom.getAsJsonObject(keyTo)
        moshi.adapter(CryptoPairPriceDto::class.java).fromJson(itemTo.toString())?.let { dto ->
          coinPairsPriceRowDtoToModel(dto)
        }
      }
    }.flatten()

  }

  private fun mapFromAllCoinPairsToFavoritePairs(
    listCryptoPairPrice: List<CoinPairPrice>,
    set: Set<String>?
  ) = run {
    set?.map { item ->
      item.substringBefore(",") to item.substringAfter(",")
    }?.flatMap { (fromSymbol, toSymbol) ->
      listCryptoPairPrice.filter {
        it.fromSymbol == fromSymbol && it.toSymbol == toSymbol
      }
    }
  }


  fun mapFromSymbolFromAllSet(set: Set<String>?) = run {
    set?.joinToString(",") { it.substringBefore(",") }
  }

  fun mapToSymbolFromAllSet(set: Set<String>?) = run {
    set?.joinToString(",") { it.substringAfter(",") }
  }

  private fun mapDetailFiatCoinDtoToModel(
    detailDto: DetailFiatCoinDto
  ) = run {
    DetailFiatCoin(
      fiatCoinName = detailDto.fiatCoinName,
      fiatCoinCode = detailDto.fiatCoinCode,
      fiatCoinSymbol = detailDto.fiatCoinSymbol,
      fiatCoinCountry = detailDto.fiatCoinCountry,
      fiatCountryFlag = detailDto.fiatCountryFlagImg
    )
  }

  private fun addToSymImgCoinPairPrice(
    listCoinPairsPrice: List<CoinPairPrice>,
    listDetailFiatCoin: List<DetailFiatCoin>,
    listCryptoNames: List<CoinName>
  ) = run {
    listCoinPairsPrice.map { crypto ->
      val detailFiat = listDetailFiatCoin.find { it.fiatCoinCode == crypto.toSymbol }
      if (detailFiat != null) {
        crypto.copy(toSymbolImg = detailFiat.fiatCountryFlag)
      } else {
        crypto
      }
    }.map { crypto ->
      val cryptoCoin = listCryptoNames.find { it.coinCode == crypto.toSymbol }
      if (cryptoCoin != null) {
        crypto.copy(toSymbolImg = cryptoCoin.coinImgUrl)
      } else {
        crypto
      }
    }
  }

  private fun addFromSymbImgCoinPairPrice(
    listCryptoPairPrice: List<CoinPairPrice>,
    listDetailFiatCoin: List<DetailFiatCoin>
  ) = run {

    listCryptoPairPrice.map { crypto ->
      val symbol = crypto.fromSymbolImg ?: ""
      if (symbol.contains("no-image")) {
        val detail = listDetailFiatCoin.find { it.fiatCoinCode == crypto.fromSymbol }
        if (detail != null) {
          crypto.copy(fromSymbolImg = detail.fiatCountryFlag)
        } else {
          crypto
        }
      } else {
        crypto.copy(fromSymbolImg = CRYPTO_IMAGE_URL + crypto.fromSymbolImg)
      }
    }
  }

  private fun coinPairsPriceRowDtoToModel(
    coin: CryptoPairPriceDto
  ) = run {
    CoinPairPrice(
      id = coin.fromSymbol + coin.toSymbol,
      fromSymbol = coin.fromSymbol,
      fromSymbolImg = coin.fromSymbolImg,
      toSymbol = coin.toSymbol,
      toSymbolImg = null,
      price = coin.price?.toFloat()?.getIntString(),
      updateDate = coin.update?.toLong()?.convertTimestampToDate(),
      updateTime = coin.update?.toLong()?.convertTimestampToTime()
    )
  }

  private fun cryptoCoinNameDtoToModel(
    elementDto: CryptoCoinNameDto
  ) = run {
    CoinName(
      coinId = elementDto.coinId ?: -1,
      coinCode = elementDto.coinCode ?: "",
      coinName = elementDto.coinName ?: "",
      coinImgUrl = (CRYPTO_IMAGE_URL + elementDto.coinImgUrl)
    )
  }

  fun mapJsonObjectToFiatCoinsValue(
    jsonContainer: FiatPairPriceContainerDto?,
    listDetailFiatCoin: List<DetailFiatCoin>
  ): CoinPairPrice?
  {
    return jsonContainer?.let { mapJsonObjectToFiatCoinsValueDto(it) }?.let { coin ->
      val fromSymbolFlag = listDetailFiatCoin.find { it.fiatCoinCode == coin.fromSymbol }
      val toSymbolFlag = listDetailFiatCoin.find { it.fiatCoinCode == coin.toSymbol }
      CoinPairPrice(
        id = coin.fromSymbol + coin.toSymbol,
        fromSymbol = coin.fromSymbol,
        fromSymbolImg = fromSymbolFlag?.fiatCountryFlag,
        toSymbol = coin.toSymbol,
        toSymbolImg = toSymbolFlag?.fiatCountryFlag,
        price = coin.price,
        updateDate = coin.update?.toLong()?.convertTimestampToDate(),
        updateTime = coin.update?.toLong()?.convertTimestampToTime()
      )
    }
  }

  private fun mapJsonObjectToFiatCoinsValueDto(
    jsonContainer: FiatPairPriceContainerDto
  ) : FiatPairPriceDto? {
    return jsonContainer.toSymbols?.let { jsonObject ->
      val keySet = jsonObject.keySet()
      keySet?.firstNotNullOfOrNull { key ->
        val price = jsonObject.getAsJsonPrimitive(key).toString()
        FiatPairPriceDto(
          fromSymbol = jsonContainer.fromSymbol,
          toSymbol = key,
          price = price,
          update = jsonContainer.update
        )
      }
    }
//    return jsonContainer.toSymbols?.let { jsonObject ->
//      val keySet = jsonObject.keySet()
//      keySet?.firstNotNullOfOrNull { key ->
//        val price = jsonObject.getAsJsonPrimitive(key).toString()
//          FiatPairPriceDto(
//            fromSymbol = jsonContainer.fromSymbol,
//            toSymbol = key,
//            price = price,
//            update = jsonContainer.update
//          )
//      }
//    }
  }

}