package app.demo.weds.view.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.demo.weds.components.HallList
import app.demo.weds.components.HotelList
import app.demo.weds.components.ResortList
import app.demo.weds.data.hall
import app.demo.weds.data.resort
import app.demo.weds.data.sample
import app.demo.weds.ui.theme.LightGold
import app.demo.weds.view.home.SectionTitle
import app.demo.weds.view.home.SubSectionTitle
import app.oye.weds.R
import coil.compose.AsyncImage

@Composable
fun Booking(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize().padding(bottom = 10.dp)
    ) {
        AsyncImage(
            model = R.drawable.back,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                BookTop()
            }
             item {
                 PickVenue()
             }
            item {
               Resort()
            }
            item {
                Hall()
            }
        }
    }
}

@Composable
fun PickVenue(){
    Box(modifier = Modifier.fillMaxWidth()){
        Column (modifier = Modifier.fillMaxSize(),){
            SectionTitle("PICK YOUR VENUE")
            Spacer(modifier = Modifier.height(10.dp))
            SubSectionTitle("HOTELS")
            HotelList(sample)
        }
    }
}


@Composable
fun Resort(){
    Box(modifier = Modifier.fillMaxWidth()){
        Column (modifier = Modifier.fillMaxSize(),){
            Spacer(modifier = Modifier.height(20.dp))
            SubSectionTitle("RESORTS")
            ResortList(resort)
        }
    }
}


@Composable
fun Hall(){
    Box(modifier = Modifier.fillMaxWidth()){
        Column (modifier = Modifier.fillMaxSize(),){
            Spacer(modifier = Modifier.height(20.dp))
            SubSectionTitle("BANQUET HALL")
            HallList(hall)
        }
    }
}



@Composable
fun BookTop() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp)
    ) {
        AsyncImage(
            model = R.drawable.topbackground,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize() ,
            colorFilter = ColorFilter.tint(LightGold)
        )
        Column (modifier = Modifier.fillMaxSize().padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Bookings",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            SimpleDropdownMenu(listOf(
                "Agra",
                "Delhi",
                "Jaipur",
                "Bihar",
                "Rajasthan",
                "Hyderabad",
                "Pune",
                "Goa"
            ))
            Spacer(modifier = Modifier.height(10.dp))

            AsyncImage(
                model = R.drawable.agra,
                contentDescription = null,
                modifier = Modifier
                    .size(230.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Composable
fun SimpleDropdownMenu(places: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(places.firstOrNull() ?: "") }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = true }
                .padding(horizontal = 4.dp, vertical = 2.dp)
        ) {
            Text(
                text = selectedOption,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                painter = painterResource(id = R.drawable.down),
                contentDescription = "Dropdown Arrow",
                modifier = Modifier.size(14.dp),
                tint = Color.Unspecified
            )
        }
        if (places.isNotEmpty()) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                containerColor = Color.White,
                tonalElevation = 8.dp,
                shadowElevation = 0.dp,
                offset = androidx.compose.ui.unit.DpOffset(x = (-70).dp, y = 0.dp)
            ) {
                places.forEach { label ->
                    DropdownMenuItem(
                        text = { Text(label) },
                        onClick = {
                            selectedOption = label
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
