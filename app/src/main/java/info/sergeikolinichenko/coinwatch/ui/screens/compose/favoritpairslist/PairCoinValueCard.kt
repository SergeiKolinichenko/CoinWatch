package info.sergeikolinichenko.coinwatch.ui.screens.compose.favoritpairslist

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import info.sergeikolinichenko.coinwatch.R
import info.sergeikolinichenko.coinwatch.models.CoinPairPrice

/** Created by Sergei Kolinichenko on 25.10.2023 at 19:28 (GMT+3) **/

@Composable
fun PairCoinValueCard(
  modifier: Modifier = Modifier,
  coinPairPrice: CoinPairPrice
) {
  Card(
    modifier = modifier
      .padding( 4.dp)
      .fillMaxWidth(),
    shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)
  ) {
    Row(
      modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      FromCoin(coinPairPrice = coinPairPrice)
      ExchangeInfo(coinPairPrice = coinPairPrice)
      ToCoin(coinPairPrice = coinPairPrice)
    }
  }
}

@Composable
fun ExchangeInfo(coinPairPrice: CoinPairPrice) {
  Column(
    modifier = Modifier,
    verticalArrangement = Arrangement.SpaceEvenly
  ) {

    Text(
      fontSize = 12.sp,
      fontWeight = FontWeight.Normal,
      fontFamily = FontFamily.SansSerif,
      text = stringResource(R.string.last_update_date_pair_price)
    )
    Row(
      verticalAlignment = Alignment.Bottom
    ) {
      Text(
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        fontFamily = FontFamily.SansSerif,
        text = coinPairPrice.updateDate ?: stringResource(R.string.missing_transaction_date_crypto_pair_price)
      )
      Spacer(modifier = Modifier.padding(2.dp))
      Text(
        fontSize = 10.sp,
        fontWeight = FontWeight.W500,
        fontFamily = FontFamily.SansSerif,
        text = coinPairPrice.updateTime ?: stringResource(R.string.missing_transaction_date_crypto_pair_price)
      )
    }

    Spacer(modifier = Modifier.padding(4.dp))

    Text(
      fontSize = 12.sp,
      fontWeight = FontWeight.Normal,
      fontFamily = FontFamily.SansSerif,
      text = stringResource(R.string.title_cripto_pair_price)
    )
    Text(
      fontSize = 16.sp,
      fontWeight = FontWeight.W900,
      fontFamily = FontFamily.SansSerif,
      text = coinPairPrice.price ?: stringResource(R.string.no_exchange_value_crypto_pair_price)
    )
  }
}

@Composable
fun FromCoin(coinPairPrice: CoinPairPrice) {

  Column(
    modifier = Modifier,
    verticalArrangement = Arrangement.SpaceBetween,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

      AsyncImage(
        modifier = Modifier
          .size(50.dp)
          .clip(CircleShape),
        model = coinPairPrice.fromSymbolImg,
        contentDescription = stringResource(R.string.crypto_coin_name)
      )

    Text(
      fontSize = 20.sp,
      fontWeight = FontWeight.W900,
      fontFamily = FontFamily.SansSerif,
      text = coinPairPrice.fromSymbol ?: stringResource(R.string.no_coin_symbol_crypto_pair_price)
    )
  }
}

@Composable
fun ToCoin(coinPairPrice: CoinPairPrice) {
  Column(
    modifier = Modifier,
    verticalArrangement = Arrangement.SpaceBetween,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    AsyncImage(
      modifier = Modifier
        .size(50.dp)
        .clip(CircleShape),
      model = coinPairPrice.toSymbolImg ?: stringResource(R.string.no_coin_symbol_crypto_pair_price),
      contentDescription = stringResource(R.string.crypto_coin_name)
    )

    Text(
      fontSize = 20.sp,
      fontWeight = FontWeight.W900,
      fontFamily = FontFamily.SansSerif,
      text = coinPairPrice.toSymbol ?: stringResource(R.string.no_coin_symbol_crypto_pair_price)
    )
  }
}