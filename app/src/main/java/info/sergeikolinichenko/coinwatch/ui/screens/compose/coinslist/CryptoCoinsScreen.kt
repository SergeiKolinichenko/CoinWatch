package info.sergeikolinichenko.coinwatch.ui.screens.compose.coinslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import info.sergeikolinichenko.coinwatch.models.CoinName
import info.sergeikolinichenko.coinwatch.navigation.NavigationState
import info.sergeikolinichenko.coinwatch.navigation.Screen
import info.sergeikolinichenko.coinwatch.ui.screens.compose.HandleAlertDialog
import info.sergeikolinichenko.coinwatch.ui.screens.compose.HandleSnackebar
import info.sergeikolinichenko.coinwatch.ui.screens.compose.ShowProgressIndicator
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents
import info.sergeikolinichenko.coinwatch.ui.screens.events.CryptoCoinsScreenEvents.*
import info.sergeikolinichenko.coinwatch.ui.screens.states.CoinPairsScreenStates
import info.sergeikolinichenko.coinwatch.ui.screens.states.CryptoCoinsScreenStates
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.CryptoCoinsViewModel
import info.sergeikolinichenko.coinwatch.utils.getApplicationComponent

/** Created by Sergei Kolinichenko on 23.10.2023 at 18:10 (GMT+3) **/

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CryptoCoinsScreen(
  navigationState: NavigationState
) {

  val viewModel: CryptoCoinsViewModel =
    viewModel(factory = getApplicationComponent().getViewModelsFactory())

  // collectAsState() is a Compose function that collects a State<T> from a Flow<T>
  val screenStates by viewModel.cryptoCoinsScreenStates.collectAsState(
    initial = CoinPairsScreenStates.Initial
  )

  // SnackbarHostState is a state object that can be used to show snackbars.
  val snackbarHostState by remember { mutableStateOf(SnackbarHostState()) }
  // listOfCoins is a list of coins that will be displayed on the screen
  var listOfCoins by remember { mutableStateOf(listOf<CoinName>()) }
  // showProgressIndicator is a state that will be used to show the progress indicator
  val showProgressIndicator = remember { mutableStateOf(false) }
  // searchText is a state that will be used to search for coins
  var searchText by remember { mutableStateOf("") } // text in searchbar

  when (screenStates) {

    CryptoCoinsScreenStates.Initial -> { // initial state
      viewModel.handleEvents(Initial)
    }

    CryptoCoinsScreenStates.ShowProgressIndicator -> { // show progress indicator
      showProgressIndicator.value = true
      viewModel.handleEvents(ProgressIndicatorShown)
    }

    is CryptoCoinsScreenStates.ShowCoinsList -> { // show list of coins & hide progress indicator
      showProgressIndicator.value = false
      listOfCoins = (screenStates as CryptoCoinsScreenStates.ShowCoinsList).list
      viewModel.handleEvents(CoinsListShown)
    }

    is CryptoCoinsScreenStates.ShowSearchingCoinsList -> { //show list of coins from search
      listOfCoins = (screenStates as CryptoCoinsScreenStates.ShowSearchingCoinsList).list
    }

    is CryptoCoinsScreenStates.ShowSnackbar -> { // show snackbar
      HandleSnackebar(
        snackbarHostState = snackbarHostState,
        snackbarData = (screenStates as CryptoCoinsScreenStates.ShowSnackbar).data,
        onResultSnackbar = { result, withDismissAction ->
          if (withDismissAction) viewModel.handleEvents(
            SnackbarResult(
              result = result
            )
          )
        }
      )
    }

    is CryptoCoinsScreenStates.ShowAlertDialog -> { // show alert dialog
      HandleAlertDialog(
        alertDialogData = (screenStates as CryptoCoinsScreenStates.ShowAlertDialog).data,
        onPushDialogButtons = { reaction ->
          viewModel.handleEvents(ResaultAlertDialog(reaction = reaction))
        }
      )
    }

    CryptoCoinsScreenStates.ClearSearchText -> { // clear searchbar
      searchText = "" // clear searchbar
      viewModel.handleEvents(SearchbarSearchingText(searchText = ""))
    }

    CryptoCoinsScreenStates.Cancel -> { // cancel
      navigationState.navigateTo(Screen.ListFavoriteCoins.route)
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
          key = { it.coinId }
        ) { coinName ->
          coinName.let {
            CoinCard(
              coinCode = it.coinCode,
              coinName = it.coinName,
              coinImage = it.coinImgUrl,
              onClick = {
                viewModel.handleEvents(
                  PushItemCryptoList(coinCode = it.coinCode)
                )
              }
            )
          }
        }
      }
    )
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
  Box(
    modifier = Modifier
      .fillMaxSize()
      .statusBarsPadding()
  ) {
    Box(
      modifier = Modifier
        .align(Alignment.BottomCenter)
        .background(MaterialTheme.colorScheme.primary)
        .fillMaxWidth()
        .windowInsetsPadding(WindowInsets.systemBars)
    )
  }
  ShowProgressIndicator(state = showProgressIndicator.value)
}