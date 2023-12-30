package info.sergeikolinichenko.coinwatch.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** Created by Sergei Kolinichenko on 07.10.2023 at 17:34 (GMT+3) **/

object ApiFactory {
  private const val CRYPTO_BASE_URL = "https://min-api.cryptocompare.com/data/"
  const val CRYPTO_IMAGE_URL = "https://cryptocompare.com"

  private const val FIAT_BASE_URL = "https://openexchangerates.org/api/"
  private const val EXCHANGERATE_BASE_URL = "https://v6.exchangerate-api.com/v6/"
  private const val FIAT_DETAILS =
    "https://gist.githubusercontent.com/manishtiwari25/d3984385b1cb200b98bcde6902671599/raw/b5bc497e9f26f95cda2e32bbd40ff3da4a494cff/"

  private val okHttpClient = OkHttpClient.Builder()

  init {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    okHttpClient.addInterceptor(logging)
  }

  fun getCryptoApi(): ApiService = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(CRYPTO_BASE_URL)
    .build()
    .create(ApiService::class.java)

  fun getFiatApi(): ApiService = Retrofit.Builder()
    .baseUrl(FIAT_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient.build())
    .build()
    .create(ApiService::class.java)

  fun getExchangeRateApi(): ApiService = Retrofit.Builder()
    .baseUrl(EXCHANGERATE_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient.build())
    .build()
    .create(ApiService::class.java)

  fun getFiatDetails(): ApiService = Retrofit.Builder()
    .baseUrl(FIAT_DETAILS)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient.build())
    .build()
    .create(ApiService::class.java)

}