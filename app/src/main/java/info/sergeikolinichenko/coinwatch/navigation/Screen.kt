package info.sergeikolinichenko.coinwatch.navigation

/** Created by Sergei Kolinichenko on 25.10.2023 at 18:07 (GMT+3) **/

sealed class Screen(val route: String) {
  object ListCryptoCoins: Screen(ROUTE_FULL_LIST_CRYPTO_COINS)
  object ListFiatCoins: Screen(ROUTE_FULL_LIST_FIAT_COINS)
  object ListFavoriteCoins: Screen(ROUTE_LIST_FAVORITE_COINS)
  object CancelApp: Screen(ROUTE_CANCEL_APP)

  companion object {
    private const val ROUTE_FULL_LIST_CRYPTO_COINS = "full_list_crypto_coins"
    private const val ROUTE_FULL_LIST_FIAT_COINS = "full_list_fiat_coins"
    private const val ROUTE_LIST_FAVORITE_COINS = "list_favorite_coins"
    private const val ROUTE_CANCEL_APP = "cancel_application"
  }
}
