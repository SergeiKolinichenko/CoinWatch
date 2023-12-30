package info.sergeikolinichenko.coinwatch.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

/** Created by Sergei Kolinichenko on 31.10.2023 at 09:43 (GMT+3) **/

class NavigationState (
  val navHostController: NavHostController
) {

  fun navigateTo(route: String) {
    navHostController.navigate(route = route){
      popUpTo(navHostController.graph.startDestinationId) {
        saveState = true
      }
      launchSingleTop = true
      restoreState = true
    }
  }
}

@Composable
fun rememberNavigationState(
  navHostController: NavHostController = rememberNavController()
): NavigationState {
  return remember {
    NavigationState(navHostController = navHostController)
  }
}