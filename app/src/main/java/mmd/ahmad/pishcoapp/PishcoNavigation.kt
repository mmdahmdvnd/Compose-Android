package mmd.ahmad.pishcoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mmd.ahmad.pishcoapp.view.screen.CollectionRequestPage
import mmd.ahmad.pishcoapp.view.screen.MainScreen
import mmd.ahmad.pishcoapp.view.screen.NewRequestPage
import mmd.ahmad.pishcoapp.viewModel.MainViewModel

@Composable
fun PishcoNavigation(navController: NavController, viewModel: MainViewModel) {
    NavHost(navController = navController as NavHostController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.CollectionRequestPage.route) {
            CollectionRequestPage(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.NewRequestPage.route) {
            NewRequestPage(navController = navController, viewModel = viewModel)
        }
    }
}

sealed class Screen(val route: String) {
    object MainScreen : Screen("home")
    object CollectionRequestPage : Screen("collectionRequest")
    object NewRequestPage : Screen("newRequestPage")
}