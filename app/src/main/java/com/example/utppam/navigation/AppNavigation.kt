package com.example.utppam.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.utppam.data.FoodItem
import com.example.utppam.screens.CheckoutScreen
import com.example.utppam.screens.HomeScreen
import com.example.utppam.screens.MenuDetailScreen
import com.example.utppam.screens.MenuListScreen
import com.example.utppam.screens.SuccessScreen

object Routes {
    const val HOME = "home"
    const val MENU = "menu"
    const val DETAIL = "detail/{itemId}"
    const val CHECKOUT = "checkout"
    const val SUCCESS = "success"
    fun detail(itemId: Int) = "detail/$itemId"
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
                onItemClick = { itemId ->
                    navController.navigate(Routes.detail(itemId))
                },
                onCheckout = {
                    navController.navigate(Routes.CHECKOUT)
                }
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(
                navArgument("itemId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: return@composable
            val item = menuItems.find { it.id == itemId } ?: return@composable

            MenuDetailScreen(
                item = item,
                onQuantityChange = onQuantityChange,
                onBack = { navController.popBackStack() }
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
