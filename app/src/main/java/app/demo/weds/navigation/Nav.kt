package app.demo.weds.navigation

import LoginScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.demo.weds.natwork.viewmodel.AuthViewModel

import app.demo.weds.view.auth.SignUpScreen
import app.demo.weds.view.book.Booking
import app.demo.weds.view.budget.Budget
import app.demo.weds.view.home.Home
import org.koin.androidx.compose.koinViewModel




@Composable
fun Nav() {
    val navController = rememberNavController()
    val items = BottomBar()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val selectedIndex = items.indexOfFirst { it.route == currentRoute }
        .takeIf { it >= 0 }


    val bottomBarRoutes = listOf(
        Screens.Home.route,
        Screens.Book.route,
        Screens.Budget.route,
    )

    val showBottomBar = currentRoute != null && currentRoute in bottomBarRoutes

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(
                    navController = navController,
                    items = items,
                    selectedIndex = selectedIndex,
                    bottomNavStartRoute = Screens.Home.route
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.LoginScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(Screens.SignupScreen.route) {
                SignUpScreen(navController,)
            }
            composable(Screens.Home.route) {
                Home(navController)
            }
            composable(Screens.Book.route) {
                Booking(navController)
            }
            composable(Screens.Budget.route) {
                Budget(navController)
            }
        }
    }
}


data class BottomNavItem(
    val icon: Painter,
    val selectedIcon: Painter,
    val route: String,
    val label: String
)

sealed class Screens(val route: String, val label: String) {
    object LoginScreen : Screens("loginscreen_route", "LoginScreen")
    object SignupScreen : Screens("signupscreen_route", "SignupScreen")
    object Home : Screens("home_route", "Home")
    object Book : Screens("book_route", "Book")
    object Budget : Screens("budget_route", "Budget")
}




