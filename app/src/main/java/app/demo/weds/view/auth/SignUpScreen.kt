package app.demo.weds.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.demo.weds.natwork.resource.Resource
import app.demo.weds.natwork.viewmodel.AuthViewModel
import app.demo.weds.navigation.Screens
import app.demo.weds.ui.theme.DarkGold
import app.demo.weds.ui.theme.LightGold
import app.demo.weds.ui.theme.Marron
import app.oye.weds.R
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(navController: NavController, viewModel: AuthViewModel = koinViewModel()) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    val sign by viewModel.signUpState.collectAsState()

    LaunchedEffect(sign) {
        if (sign is Resource.Success<*>) {
            navController.navigate(Screens.LoginScreen.route) {
                popUpTo(Screens.SignupScreen.route) { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize().background(LightGold)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = R.drawable.couple,
                    contentDescription = null,
                    modifier = Modifier.size(250.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Sign Up",
                    color = Marron,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                OutlinedTextField(
                    value = otp,
                    onValueChange = { otp = it },
                    label = { Text("Create Password") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                Button(
                    onClick = {
                        if (name.isNotBlank() && email.isNotBlank() && otp.isNotBlank()) {
                            viewModel.signUp(name, email, otp)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(50.dp)
                ) {
                    Text(text = "Sign Up")
                }
            }

            Text(
                text = "Please Login after 5 to 10 minutes",
                color = Color.Red,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Already have an account?")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Login",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { navController.navigate(Screens.LoginScreen.route) }
                )
            }
        }


        if (sign is Resource.Loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Marron)
            }
        }


        if (sign is Resource.Error) {
            Text(
                text = (sign as Resource.Error).message,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 16.dp)
            )
        }
    }
}

