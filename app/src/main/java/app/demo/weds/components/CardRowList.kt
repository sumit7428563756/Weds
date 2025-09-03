package app.demo.weds.components


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import app.oye.weds.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CardRowList(modifier: Modifier,navController: NavController) {
    val cards = listOf(
        Pair("Wedding",  R.drawable.weding),
        Pair("Reception", R.drawable.reception ),
        Pair("Haldi", R.drawable.haldi),
        Pair("Mehendi",  R.drawable.mehndi),
        Pair("HoneyMoon",  R.drawable.honeymoon)
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(start = 5.dp)
    ) {
        items(cards) { card ->
            CardRow(
                text = card.first,
                icon = card.second,
                navController
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}



@Composable
fun VendorRowList(modifier: Modifier) {
    val cards = listOf(
        Pair("Decor", R.drawable.decor),
        Pair("Makeup", R.drawable.makeup ),
        Pair("Caterer", R.drawable.caterer),
        Pair("Shopping",  R.drawable.shop),
        Pair("Photography",  R.drawable.photography))


    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(start = 5.dp)
    ) {
        items(cards) { card ->
            VendorRow(
                text = card.first,
                icon = card.second
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}

@Composable
fun TrendingRowList(modifier: Modifier = Modifier) {
    val cards = listOf(
        R.drawable.lahanga1,
        R.drawable.lahanga2,
        R.drawable.lahanga3,
        R.drawable.lahanga4
    )

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    ) {
        items(cards) { card ->
            TrendingRow(
                icon = card
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}


@Composable
fun GroomRowList(modifier: Modifier = Modifier) {
    val cards = listOf(
        R.drawable.sherwani1,
        R.drawable.sherwani2,
        R.drawable.sherwani3,
        R.drawable.sherwani4
    )

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    ) {
        items(cards) { card ->
            TrendingRow(
                icon = card
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}


