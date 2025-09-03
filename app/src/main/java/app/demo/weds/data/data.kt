package app.demo.weds.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import app.demo.weds.view.book.Resort
import app.oye.weds.R

data class Hotels(
    val id: Int,
    val name: String,
    val price: String,
    val rating: String,
    @DrawableRes val img: Int
)


data class Resorts(
    val id: Int,
    val name: String,
    val price: String,
    val rating: String,
    @DrawableRes val img: Int
)

data class Halls(
    val id: Int,
    val name: String,
    val price: String,
    val rating: String,
    @DrawableRes val img: Int
)


val hall = listOf(
    Halls(
        id = 0,
        name = "Banquet Hall",
        price = "80K/Day",
        rating = "4.6",
        img = R.drawable.hall
    ),
    Halls(
        id = 1,
        name = "Sunshine Hall",
        price = "1.2 Lakh/Day",
        rating = "4.8",
        img = R.drawable.hall1
    ),
    Halls(
        id = 2,
        name = "Premium Hall",
        price = "1.6 Lakh/Day",
        rating = "4.4",
        img = R.drawable.hall2
    ),
    Halls(
        id = 3,
        name = "Linked Hall",
        price = "90K/Day",
        rating = "4.1",
        img = R.drawable.hall3
    )
)


val resort = listOf(
    Resorts(
        id = 0,
        name = "Duplex Resort",
        price = "2.5 Lakh/Day",
        rating = "4.6",
        img = R.drawable.resort
    ),
    Resorts(
        id = 1,
        name = "Indus Resort",
        price = "2.9 Lakh/Day",
        rating = "4.8",
        img = R.drawable.resort1
    ),
    Resorts(
        id = 2,
        name = "Miami Resort",
        price = "2.0 Lakh/Day",
        rating = "4.2",
        img = R.drawable.resort2
    ),
    Resorts(
        id = 3,
        name = "Hindon Resort",
        price = "2.4 Lakh/Day",
        rating = "4.7",
        img = R.drawable.resort3
    )
)

val sample = listOf(
    Hotels(
        id = 0,
        name = "Bloom Hotel",
        price = "1.5 Lakh/Day",
        rating = "4.6",
        img = R.drawable.hotel
    ),
    Hotels(
        id = 1,
        name = "Holiday Hotel",
        price = "1.2 Lakh/Day",
        rating = "4.8",
        img = R.drawable.hotel1
    ),
    Hotels(
        id = 2,
        name = "Sunshine Hotel",
        price = "1.8 Lakh/Day",
        rating = "4.9",
        img = R.drawable.hotel2
    ),
    Hotels(
        id = 3,
        name = "Dulex Hotel",
        price = "1.1 Lakh/Day",
        rating = "4.1",
        img = R.drawable.hotel3
    )
)