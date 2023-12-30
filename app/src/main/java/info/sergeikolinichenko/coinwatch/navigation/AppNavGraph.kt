package info.sergeikolinichenko.coinwatch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/** Created by Sergei Kolinichenko on 25.10.2023 at 18:17 (GMT+3) **/

@Composable
fun AppNavGraph(
  navHostController: NavHostController,
  listFavoriteCoinsScreenContent: @Composable () -> Unit,
  listCryptoCoinsScreenContent: @Composable () -> Unit,
  listFiatCoinsScreenContent: @Composable () -> Unit,
  cancelApplication: @Composable () -> Unit
) {

  NavHost(
    navController = navHostController,
    startDestination = Screen.ListFavoriteCoins.route
  ) {
    composable(route = Screen.ListFavoriteCoins.route) {
      listFavoriteCoinsScreenContent()
    }
    composable(route = Screen.ListCryptoCoins.route) {
      listCryptoCoinsScreenContent()
    }
    composable(route = Screen.ListFiatCoins.route) {
      listFiatCoinsScreenContent()
    }
    composable(route = Screen.CancelApp.route) {
      cancelApplication()
    }
  }
}