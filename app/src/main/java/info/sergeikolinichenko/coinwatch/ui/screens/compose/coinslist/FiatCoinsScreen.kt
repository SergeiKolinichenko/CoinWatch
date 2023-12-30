package info.sergeikolinichenko.coinwatch.ui.screens.compose.coinslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.navigation.NavigationState
import info.sergeikolinichenko.coinwatch.navigation.Screen
import info.sergeikolinichenko.coinwatch.ui.screens.compose.HandleAlertDialog
import info.sergeikolinichenko.coinwatch.ui.screens.compose.HandleSnackebar
import info.sergeikolinichenko.coinwatch.ui.screens.compose.ShowProgressIndicator
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents
import info.sergeikolinichenko.coinwatch.ui.screens.events.FiatCoinsScreenEvents
import info.sergeikolinichenko.coinwatch.ui.screens.events.FiatCoinsScreenEvents.*
import info.sergeikolinichenko.coinwatch.ui.screens.states.FiatCoinsScreenStates
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.FiatCoinsViewModel
import info.sergeikolinichenko.coinwatch.utils.getApplicationComponent

/** Created by Sergei Kolinichenko on 01.12.2023 at 20:43 (GMT+3) **/
/*
On this screen user can see all fiat coins,
add them to favorites and see their price in different currencies.
*/

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FiatCoinsScreen(
  navigationState: NavigationState
) {

  val viewModel: FiatCoinsViewModel =
    viewModel(factory = getApplicationComponent().getViewModelsFactory())

  val screenStates by viewModel.fiatCoinsScreenStates.collectAsState(
    initial = FiatCoinsScreenStates.Initial
  )

  // listOfCoins is a list of coins that will be displayed on the screen
  var listOfCoins by remember { mutableStateOf(listOf<CoinName>()) }
  // showProgressIndicator is a state that will be used to show the progress indicator
  val showProgressIndicator = remember { mutableStateOf(false) }
  // SnackbarHostState is a state object that can be used to show snackbars.
  val snackbarHostState by remember { mutableStateOf(SnackbarHostState()) }
  // searchText is a state that will be used to search for coins
  var searchText by remember { mutableStateOf("") } // text in searchbar

  when(screenStates) {
    FiatCoinsScreenStates.Initial -> { // initial state
      viewModel.handleEvents(Initial)
    }

    FiatCoinsScreenStates.ShowProgressIndicator -> { // show progress indicator
      showProgressIndicator.value = true
      viewModel.handleEvents(ProgressIndicatorShown)
    }

    FiatCoinsScreenStates.Cancel -> { // cancel
      navigationState.navigateTo(Screen.ListFavoriteCoins.route)
    }

    FiatCoinsScreenStates.ClearSearchText -> { // clear search text
      searchText = ""
      viewModel.handleEvents(SearchbarSearchingText(searchText = searchText))
    }

    is FiatCoinsScreenStates.ShowCoinsList -> { // show coins list
      listOfCoins = (screenStates as FiatCoinsScreenStates.ShowCoinsList).list
      showProgressIndicator.value = false
      viewModel.handleEvents(CoinsListShown)
    }

    is FiatCoinsScreenStates.ShowSearchingCoinsList -> { // show searching coins list
      listOfCoins = (screenStates as FiatCoinsScreenStates.ShowSearchingCoinsList).list
      showProgressIndicator.value = false
    }

    is FiatCoinsScreenStates.ShowSnackbar -> { // show snackbar
      HandleSnackebar(
        snackbarHostState = snackbarHostState,
        snackbarData = (screenStates as FiatCoinsScreenStates.ShowSnackbar).data
      ) { result, withDismissAction ->
        if (withDismissAction) {
          viewModel.handleEvents(
            SnackbarResult(result = result)
          )
        }
      }
    }

    is FiatCoinsScreenStates.ShowAlertDialog -> { // show alert dialog
      HandleAlertDialog(
        alertDialogData = (screenStates as FiatCoinsScreenStates.ShowAlertDialog).data,
        onPushDialogButtons = { reaction ->
          viewModel.handleEvents(
            ResaultAlertDialog(reaction = reaction)
          )
        }
      )
    }
  }

  Column(
    modifier = Modifier
      .statusBarsPadding()
      .navigationBarsPadding(),
  ) {
    LazyColumn(
      modifier = Modifier
        .weight(1F),
      reverseLayout = true,
      content = {
      items(
        items = listOfCoins,
        key = { coin -> coin.coinCode }
      ) { coinName ->
        CoinCard(
          coinCode = coinName.coinCode,
          coinName = coinName.coinName,
          coinImage = coinName.coinImgUrl,
          onClick = {
            viewModel.handleEvents(PushItemFiatList(coinCode = coinName.coinCode))
          }
        )

      }
    })
    SnackbarHost(
      hostState = snackbarHostState
    )
    CoinsSearchBar(
      modifier = Modifier
        .imePadding()
        .imeNestedScroll(),
      searchText = searchText,
      onChangeSearchText = {
        searchText = it
        viewModel.handleEvents(
          SearchbarSearchingText(searchText = it)
        )
      },
      onClickLeadingIcon = {
        viewModel.handleEvents(ClearSearchText)
      }
    )
  }
  ShowProgressIndicator(state = showProgressIndicator.value)
}