package app.demo.weds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.demo.weds.data.Halls
import app.demo.weds.data.Hotels
import app.demo.weds.data.Resorts
import app.demo.weds.ui.theme.Marron
import app.oye.weds.R
import coil.compose.AsyncImage

@Composable
fun Hotels(hotel: Hotels) {
    var isLiked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
    ) {

        AsyncImage(
            model = hotel.img,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
            contentScale = ContentScale.Crop
        )

        // Hotel Details
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = hotel.name,
                color = Color(0xFF1A1A1A),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = hotel.rating,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Icon(
                    painter = painterResource(if (isLiked) R.drawable.like else R.drawable.heart),
                    contentDescription = null,
                    tint = if (isLiked) Marron else Color.Gray,
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { isLiked = !isLiked }
                )
            }
        }
    }
}



@Composable
fun Resorts(resorts: Resorts) {
    var isLiked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
    ) {
        AsyncImage(
            model = resorts.img,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
            contentScale = ContentScale.Crop
        )

        // Hotel Details
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = resorts.name,
                color = Color(0xFF1A1A1A),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = resorts.rating,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Icon(
                    painter = painterResource(if (isLiked) R.drawable.like else R.drawable.heart),
                    contentDescription = null,
                    tint = if (isLiked) Marron else Color.Gray,
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { isLiked = !isLiked }
                )
            }
        }
    }
}


@Composable
fun Halls(halls: Halls) {
    var isLiked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
    ) {
        AsyncImage(
            model = halls.img,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
            contentScale = ContentScale.Crop
        )

        // Hotel Details
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = halls.name,
                color = Color(0xFF1A1A1A),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = null,
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = halls.rating,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Icon(
                    painter = painterResource(if (isLiked) R.drawable.like else R.drawable.heart),
                    contentDescription = null,
                    tint = if (isLiked) Marron else Color.Gray,
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { isLiked = !isLiked }
                )
            }
        }
    }
}




@Composable
fun HotelList(hotels: List<Hotels>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    ) {
        items(hotels) { hotel ->
            Hotels(hotel)
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}


@Composable
fun HallList(halls: List<Halls>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    ) {
        items(halls) { hall ->
            Halls(hall)
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}


@Composable
fun ResortList(resorts:  List<Resorts>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp)
    ) {
        items(resorts) { resort ->
           Resorts(resort)
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}




