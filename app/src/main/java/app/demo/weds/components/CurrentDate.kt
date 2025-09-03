package app.demo.weds.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun CurrentDate() {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy")
    val formattedDate = currentDate.format(formatter)

    Text(text = formattedDate)
}
