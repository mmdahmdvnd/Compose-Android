package mmd.ahmad.pishcoapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PishcoNavigation(navController: NavHostController) {
    val navController = rememberNavController()
    val requests = remember { mutableStateListOf("درخواست 1", "درخواست 2", "درخواست 3") }
    // رویداد برگشت از صفحه جدید به صفحه اصلی
    val onBack: () -> Unit = {
        navController.popBackStack()
    }
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.CollectionRequestPage.route) {
            CollectionRequestPage(navController = navController, requests = requests)
        }
        composable(route = Screen.NewRequestPage.route) {
            NewRequestPage(navController = navController,/* onBack = onBack,*/ requests = requests)
        }
    }
}

sealed class Screen(val route: String) {
    object MainScreen : Screen("home")
    object CollectionRequestPage : Screen("collectionRequest")
    object NewRequestPage : Screen("newRequestPage")
}