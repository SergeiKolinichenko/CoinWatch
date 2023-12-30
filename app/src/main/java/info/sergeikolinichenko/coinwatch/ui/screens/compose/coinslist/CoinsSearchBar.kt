package info.sergeikolinichenko.coinwatch.ui.screens.compose.coinslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import info.sergeikolinichenko.coinwatch.R

/** Created by Sergei Kolinichenko on 25.11.2023 at 09:45 (GMT+3) **/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinsSearchBar(
  modifier: Modifier = Modifier,  // modifier for searchbar
  searchText: String,  // text in searchbar
  onChangeSearchText: (searchText: String) -> Unit,  // change text in searchbar
  onClickLeadingIcon: () -> Unit  // change text in searchbar
) {

//  var searchText by remember { mutableStateOf("") } // text in searchbar

  SearchBar(
    modifier = modifier
      .padding(start = 8.dp, end = 8.dp, bottom = 4.dp)
      .fillMaxWidth(),
    placeholder = {
      Text(text = stringResource(R.string.enter_the_name_of_the_desired_coin))
    },
    leadingIcon = {
      Image(
        modifier = Modifier.clickable {
          onClickLeadingIcon()
        },
        imageVector = Icons.Default.Clear,
        contentDescription = stringResource(R.string.search_bar_icon_description_clear_window_contents)
      )
    },
    query = searchText,
    onQueryChange = { text ->
      onChangeSearchText(text)
    },
    onSearch = {

    },
    active = false,
    onActiveChange = {
    }
  ) {

  }
}