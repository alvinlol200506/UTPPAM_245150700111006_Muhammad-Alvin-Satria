package com.example.utppam.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.utppam.data.FoodItem
import com.example.utppam.screens.MenuDetailScreen
import com.example.utppam.screens.MenuListScreen

object Routes {
    const val MENU = "menu"
    const val DETAIL = "detail/{itemId}"
    fun detail(itemId: Int) = "detail/$itemId"
}

@Composable
fun AppNavigation(
    menuItems: SnapshotStateList<FoodItem>,
    onQuantityChange: (Int, Int) -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MENU
    ) {
        composable(route = Routes.MENU) {
            MenuListScreen(
                menuItems = menuItems,
                onQuantityChange = onQuantityChange,
                onItemClick = { itemId ->
                    navController.navigate(Routes.detail(itemId))
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
    }
}
