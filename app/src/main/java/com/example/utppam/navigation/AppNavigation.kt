package com.example.utppam.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.utppam.data.FoodItem
import com.example.utppam.screens.CheckoutScreen
import com.example.utppam.screens.HomeScreen
import com.example.utppam.screens.MenuListScreen
import com.example.utppam.screens.SuccessScreen

object Routes {
    const val HOME = "home"
    const val MENU = "menu"
    const val CHECKOUT = "checkout"
    const val SUCCESS = "success"
}

@Composable
fun AppNavigation(
    menuItems: SnapshotStateList<FoodItem>,
    onQuantityChange: (Int, Int) -> Unit,
    onResetOrders: () -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
        // Layar baru masuk dari kanan, layar lama keluar ke kiri
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        // Saat back: layar lama masuk dari kiri, layar baru keluar ke kanan
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } }
    ) {
        composable(route = Routes.HOME) {
            HomeScreen(
                onOrderClick = {
                    navController.navigate(Routes.MENU)
                }
            )
        }

        composable(route = Routes.MENU) {
            MenuListScreen(
                menuItems = menuItems,
                onQuantityChange = onQuantityChange,
                onCheckout = {
                    navController.navigate(Routes.CHECKOUT)
                }
            )
        }

        composable(route = Routes.CHECKOUT) {
            CheckoutScreen(
                menuItems = menuItems,
                onPay = {
                    navController.navigate(Routes.SUCCESS) {
                        popUpTo(Routes.CHECKOUT) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(route = Routes.SUCCESS) {
            SuccessScreen(
                onOrderAgain = {
                    onResetOrders()
                    navController.navigate(Routes.MENU) {
                        popUpTo(Routes.HOME) { inclusive = false }
                    }
                }
            )
        }
    }
}
