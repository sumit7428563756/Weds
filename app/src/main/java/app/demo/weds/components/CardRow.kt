package app.demo.weds.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.demo.weds.navigation.Screens
import app.demo.weds.ui.theme.DarkGold
import app.demo.weds.ui.theme.LightGold
import app.demo.weds.ui.theme.Marron
import app.oye.weds.R
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter


@Composable
fun CardRow(text: String, icon: Int,navController: NavController) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(180.dp).clip(shape = RoundedCornerShape(10.dp))
            .clickable {navController.navigate(Screens.Book.route) {
                popUpTo(Screens.Home.route) { inclusive = true }
            } },
    ) {

        AsyncImage(
            model = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(180.dp * 0.6f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Marron.copy(alpha = 0.8f))
                    )
                )
        )
        Text(
            text = text,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )

    }
}


@Composable
fun VendorRow(text: String, icon: Int) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(180.dp).clip(shape = RoundedCornerShape(10.dp))
            .clickable { },
    ) {

        AsyncImage(
            model = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(180.dp * 0.6f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Marron.copy(alpha = 0.8f))
                    )
                )
        )
        Text(
            text = text,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun TrendingRow(icon: Int) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(200.dp).clip(shape = RoundedCornerShape(15.dp))
            .clickable { },
    ) {
        AsyncImage(
            model = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
