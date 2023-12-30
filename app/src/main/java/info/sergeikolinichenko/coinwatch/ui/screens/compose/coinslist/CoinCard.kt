package info.sergeikolinichenko.coinwatch.ui.screens.compose.coinslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import info.sergeikolinichenko.coinwatch.R
import info.sergeikolinichenko.coinwatch.ui.screens.compose.ResponsiveText

/** Created by Sergei Kolinichenko on 22.10.2023 at 21:07 (GMT+3) **/

@Composable
fun CoinCard(
  coinCode: String,
  coinName: String,
  coinImage: String,
  onClick: () -> Unit
) {

  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 4.dp, vertical = 2.dp)
      .clickable {
        onClick()
      },
    shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 2.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Box(
        modifier = Modifier.weight(1F)
      ) {
        ResponsiveText(
          textStyle = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W900,
            fontSize = 26.sp
          ),
          maxLines = 1,
          textAlign = TextAlign.Start,
          text = coinCode
        )
      }
      Spacer(modifier = Modifier.padding(4.dp))
      Box(
        modifier = Modifier.weight(3F)
      ) {
        ResponsiveText(
          textStyle = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W900,
            fontSize = 16.sp
          ),
          maxLines = 3,
          textAlign = TextAlign.Start,
          text = coinName
        )
      }
      Spacer(modifier = Modifier.padding(4.dp))
      Box(
        modifier = Modifier.weight(1F)
      ) {
        AsyncImage(
          modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .align(Alignment.CenterEnd),
          model = coinImage,
          contentDescription = stringResource(R.string.crypto_coin_name)
        )
      }
    }
  }
}