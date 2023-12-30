package info.sergeikolinichenko.coinwatch.ui.screens.compose.favoritpairslist

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import info.sergeikolinichenko.coinwatch.models.CoinPairPrice
import info.sergeikolinichenko.coinwatch.ui.screens.compose.HandleSnackebar
import info.sergeikolinichenko.coinwatch.ui.screens.compose.ShowProgressIndicator
import info.sergeikolinichenko.coinwatch.ui.screens.events.CoinPairsScreenEvents
import info.sergeikolinichenko.coinwatch.ui.screens.states.CoinPairsScreenStates
import info.sergeikolinichenko.coinwatch.ui.screens.viewmodels.FavoriteCoinPairsViewModel
import info.sergeikolinichenko.coinwatch.utils.getApplicationComponent

/** Created by Sergei Kolinichenko on 25.10.2023 at 21:58 (GMT+3) **/
/*
This screen has a LazyColumn inside the Column to display the List of data CoinPairPrice.
LazyColumn items are deleted by SwipeToDismiss, by swiping EndToStart.
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteCoinPairsScreen(
  drawerState: DrawerState
) {

  val viewModel: FavoriteCoinPairsViewModel = viewModel(
    factory = getApplicationComponent().getViewModelsFactory()
  )

  val snackbarHostState = remember { mutableStateOf(SnackbarHostState()) }
  val listOfCoins = remember { mutableStateOf(listOf<CoinPairPrice>()) }
  val showProgressIndicator = remember { mutableStateOf(false) }

  val screenStates by viewModel.coinPairsScreenStates.collectAsState(
    initial = CoinPairsScreenStates.Initial
  )

  when (screenStates) {
    CoinPairsScreenStates.Initial -> {
      showProgressIndicator.value = false
    }

    CoinPairsScreenStates.Loading -> {
      showProgressIndicator.value = true
    }

    CoinPairsScreenStates.OpenNavigationDrawer -> {
      LaunchedEffect(Unit) {
        drawerState.open()
      }
    }

    is CoinPairsScreenStates.GetFavoritePairCoins -> {
      showProgressIndicator.value = false
      listOfCoins.value = (screenStates as CoinPairsScreenStates.GetFavoritePairCoins).listCoins
    }

    is CoinPairsScreenStates.ShowSnackbar -> {
      HandleSnackebar(
        snackbarHostState = snackbarHostState.value,
        snackbarData = (screenStates as CoinPairsScreenStates.ShowSnackbar).data,
        onResultSnackbar = { result, withDismissAction ->
          viewModel.handleEvent(
            CoinPairsScreenEvents.SnackbarResult(
              result = result,
              withDismissAction = withDismissAction
            )
          )
        }
      )
    }
  }
  /* Column for vertical distribution of screen elements. */
  Column(
    modifier = Modifier
      .statusBarsPadding()
  ) {
    /* LazyColumn for vertical distribution of screen elements. */
    LazyColumn(
      modifier = Modifier
        .weight(1F)
    ) {
      items(
        items = listOfCoins.value,
        key = { item -> item.id }
      ) { coinPairPrice ->

        val dismissState = rememberDismissState(
          positionalThreshold = { fullSize -> fullSize / 3 },
          confirmValueChange = {
            if (drawerState.isOpen) false
            else it == DismissValue.DismissedToStart
          }
        )

        if (dismissState.isDismissed(DismissDirection.EndToStart)) {
          viewModel.handleEvent(
            CoinPairsScreenEvents.DeletePairFromSet(item = coinPairPrice)
          )
        } else if (dismissState.dismissDirection == DismissDirection.StartToEnd) {
          OpenNavigationDrawer(drawerState = drawerState)
        }
        /* Necessary to remove LazyColumn items by swiping from right to left */
        SwipeToDismiss(
          modifier = Modifier
            .fillMaxWidth(),
          state = dismissState,
          background = {
            val color by animateColorAsState(
              when (dismissState.targetValue) {
                DismissValue.DismissedToStart -> Color.Red.copy(alpha = 0.5f)
                else -> MaterialTheme.colorScheme.background
              }, label = "dismiss background color"
            )
            Box(
              modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .fillMaxSize()
                .background(color),
              contentAlignment = Alignment.CenterEnd
            ) {
              Text(
                modifier = Modifier.padding(end = 14.dp),
                text = "DELETE",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = W900,
                fontFamily = FontFamily.SansSerif
              )
            }
          },
          dismissContent = {
            PairCoinValueCard(
              coinPairPrice = coinPairPrice
            )
          }
        )
      }
    }
    SnackbarHost(
      hostState = snackbarHostState.value
    )
    Box(
      modifier = Modifier
        .background(MaterialTheme.colorScheme.primary)
        .fillMaxWidth()
        .windowInsetsPadding(WindowInsets.systemBars)
    )
  }
  ShowProgressIndicator(state = showProgressIndicator.value)
}

@Composable
fun OpenNavigationDrawer(
  drawerState: DrawerState
) {
  LaunchedEffect(Unit) {
    drawerState.open()
  }
}

