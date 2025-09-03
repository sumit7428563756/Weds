package app.demo.weds.view.budget


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.oye.weds.R
import coil.compose.AsyncImage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import app.demo.weds.ui.theme.DarkGold
import app.demo.weds.ui.theme.LightGold
import app.demo.weds.ui.theme.Marron
import app.demo.weds.ui.theme.Pink
import app.demo.weds.view.home.SectionTitle
import me.bytebeats.views.charts.pie.PieChart
import me.bytebeats.views.charts.pie.PieChartData
import me.bytebeats.views.charts.pie.render.SimpleSliceDrawer


@Composable
fun Budget(navController: NavController){
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
                .fillMaxSize().padding(top = 30.dp)
        ) {
            item {
                SectionTitle("BUDGET")
                BudgetPieChart()
            }
            item {
                SectionTitle("GUESTS")
                GuestsPieChart()
            }
        }
    }
}




@Composable
fun GuestsPieChart() {
    var confirmed by remember { mutableStateOf("223") }
    var pending by remember { mutableStateOf("211") }
    var notAttending by remember { mutableStateOf("124") }

    // Convert to numbers safely
    val confirmedValue = confirmed.toFloatOrNull() ?: 0f
    val pendingValue = pending.toFloatOrNull() ?: 0f
    val notAttendingValue = notAttending.toFloatOrNull() ?: 0f
    val totalGuests = confirmedValue + pendingValue + notAttendingValue

    // Chart data updates automatically
    val pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice(confirmedValue, Marron),
            PieChartData.Slice(pendingValue, DarkGold),
            PieChartData.Slice(notAttendingValue, LightGold)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .height(350.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Guest Attendance",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Pie Chart
                PieChart(
                    pieChartData = pieChartData,
                    modifier = Modifier.size(150.dp),
                    sliceDrawer = SimpleSliceDrawer()
                )

                // Editable fields
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f).padding(start = 12.dp)
                ) {

                    GuestField(label = "Confirmed", value = confirmed) { confirmed = it }
                    GuestField(label = "Pending", value = pending) { pending = it }
                    GuestField(label = "Not Attending", value = notAttending) { notAttending = it }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Total Guests: ${totalGuests.toInt()}",
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun GuestField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BudgetPieChart() {
    var hotel by remember { mutableStateOf("100000") }
    var food by remember { mutableStateOf("50000") }
    var makeup by remember { mutableStateOf("20000") }
    var cater by remember { mutableStateOf("30000") }
    var photography by remember { mutableStateOf("40000") }
    var shopping by remember { mutableStateOf("25000") }


    val hotelValue = hotel.toFloatOrNull() ?: 0f
    val foodValue = food.toFloatOrNull() ?: 0f
    val makeupValue = makeup.toFloatOrNull() ?: 0f
    val caterValue = cater.toFloatOrNull() ?: 0f
    val photographyValue = photography.toFloatOrNull() ?: 0f
    val shoppingValue = shopping.toFloatOrNull() ?: 0f

    val totalExpense = hotelValue + foodValue + makeupValue + caterValue + photographyValue + shoppingValue


    val pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice(hotelValue, Marron),
            PieChartData.Slice(foodValue, DarkGold),
            PieChartData.Slice(makeupValue, LightGold),
            PieChartData.Slice(caterValue, Color.Blue),
            PieChartData.Slice(photographyValue, Color.Magenta),
            PieChartData.Slice(shoppingValue, Pink)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .height(600.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Wedding Budget",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Pie Chart
                PieChart(
                    pieChartData = pieChartData,
                    modifier = Modifier.size(150.dp),
                    sliceDrawer = SimpleSliceDrawer()
                )

                // Editable Fields
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f).padding(start = 12.dp)
                ) {
                    GuestField(label = "Hotel", value = hotel) { hotel = it }
                    GuestField(label = "Food", value = food) { food = it }
                    GuestField(label = "Makeup", value = makeup) { makeup = it }
                    GuestField(label = "Cater", value = cater) { cater = it }
                    GuestField(label = "Photography", value = photography) { photography = it }
                    GuestField(label = "Shopping", value = shopping) { shopping = it }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Total Expense: ₹${totalExpense.toInt()}",
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }
}

