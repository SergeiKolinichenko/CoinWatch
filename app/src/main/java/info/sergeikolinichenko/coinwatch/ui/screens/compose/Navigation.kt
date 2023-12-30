package info.sergeikolinichenko.coinwatch.ui.screens.compose

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.sergeikolinichenko.coinwatch.navigation.AppNavGraph
import info.sergeikolinichenko.coinwatch.navigation.NavigationItem.Companion.navigationItems
import info.sergeikolinichenko.coinwatch.navigation.rememberNavigationState
import info.sergeikolinichenko.coinwatch.ui.screens.compose.coinslist.CryptoCoinsScreen
import info.sergeikolinichenko.coinwatch.ui.screens.compose.coinslist.FiatCoinsScreen
import info.sergeikolinichenko.coinwatch.ui.screens.compose.favoritpairslist.FavoriteCoinPairsScreen
import kotlinx.coroutines.launch

/** Created by Sergei Kolinichenko on 22.11.2023 at 19:57 (GMT+3) **/

@Composable
fun Navigation() {

  val scope = rememberCoroutineScope()

  val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
  val navigationState = rememberNavigationState()
  val selectedItem = remember { mutableStateOf(navigationItems[0]) }

  /* The general application menu slides from right to left. */

  ModalNavigationDrawer(
    drawerState = drawerState,
    gesturesEnabled = true,
    drawerContent = {
      ModalDrawerSheet(
        windowInsets = DrawerDefaults.windowInsets
      ) {

        navigationItems.forEach { item ->
          NavigationDrawerItem(
            modifier = Modifier
              .padding(8.dp)
              .height(80.dp),
            label = {
              ResponsiveText(
                textStyle = TextStyle(
                  fontFamily = FontFamily.SansSerif,
                  fontWeight = FontWeight.W500,
                  fontSize = 28.sp
                ),
                maxLines = 2,
                textAlign = TextAlign.Start,
                text = stringResource(id = item.titleResId)
              )
            },
            selected = item == selectedItem.value,
            onClick = {
              scope.launch {
                drawerState.close()
              }
              navigationState.navigateTo(item.screen.route)
            }
          )
        }
      }
    }
  ) {
    /* Navigate the application to select the desired screen */
    AppNavGraph(
      navHostController = navigationState.navHostController,
      listFavoriteCoinsScreenContent = { FavoriteCoinPairsScreen(drawerState = drawerState) },
      listCryptoCoinsScreenContent = { CryptoCoinsScreen(navigationState = navigationState) },
      listFiatCoinsScreenContent = { FiatCoinsScreen(navigationState = navigationState) },
      cancelApplication = { /* TODO: 22.11.2023 */ }
    )
  }
}