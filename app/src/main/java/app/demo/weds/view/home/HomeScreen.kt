package app.demo.weds.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.demo.weds.components.CardRowList
import app.demo.weds.components.GroomRowList
import app.demo.weds.components.TrendingRowList
import app.demo.weds.components.VendorRowList
import app.demo.weds.natwork.viewmodel.AuthViewModel
import app.demo.weds.ui.theme.LightGold
import app.demo.weds.ui.theme.Marron
import app.oye.weds.R
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home(navController: NavController) {


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
            item { HomeTop() }

            item {
                SectionTitle("Booking For")
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                CardRowList(modifier = Modifier,navController)
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                SectionTitle("Vendors")
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                VendorRowList(modifier = Modifier)
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                SectionTitle("Trending")
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                SubSectionTitle("Bride's Lahangas")
                TrendingRowList(modifier = Modifier)
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                SubSectionTitle("Groom's Sherwani")
                GroomRowList()
            }
        }
    }
}

@Composable
fun HomeTop() {

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

        Row(modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Welcome",
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Hello,Guest!",
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Add a detailed profile to get\npersonalised suggestions",
                    color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Marron),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .width(180.dp)
                ) {
                    Text(
                        text = "Set up Profile",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            AsyncImage(
                model = R.drawable.couple,
                contentDescription = null,
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        color = Marron,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 10.dp)
    )
}

@Composable
fun SubSectionTitle(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 10.dp)
    )
}
