package info.sergeikolinichenko.coinwatch.navigation

import info.sergeikolinichenko.coinwatch.R

/** Created by Sergei Kolinichenko on 14.10.2023 at 20:32 (GMT+3) **/

sealed class NavigationItem(
  val screen: Screen,
  val titleResId: Int
) {
  object FavoriteCoins: NavigationItem(
    screen = Screen.ListFavoriteCoins,
    titleResId = R.string.nav_item_favorite_coin_pairs
  )

  object SelectCryptoCoinPairs: NavigationItem(
    screen = Screen.ListCryptoCoins,
    titleResId = R.string.nav_item_select_crypto_currency
  )

  object SelectFiatCoinPairs: NavigationItem(
    screen = Screen.ListFiatCoins,
    titleResId = R.string.nav_item_select_fiat_currency
  )

  object CancelApplication: NavigationItem(
    screen = Screen.CancelApp,
    titleResId = R.string.nav_item_quit_the_application
  )

  companion object {
    val navigationItems = listOf(
      FavoriteCoins,
      SelectCryptoCoinPairs,
      SelectFiatCoinPairs,
      CancelApplication
    )
  }
}
