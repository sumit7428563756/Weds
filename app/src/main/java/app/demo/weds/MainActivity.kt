package app.demo.weds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import app.demo.weds.navigation.Nav
import app.demo.weds.ui.theme.WedsTheme
import app.demo.weds.view.home.Home
import app.oye.weds.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Weds)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WedsTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    Nav()
                }
            }
        }
    }
}
