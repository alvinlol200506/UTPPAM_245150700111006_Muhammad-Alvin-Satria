package com.example.utppam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.utppam.data.sampleMenu
import com.example.utppam.navigation.AppNavigation
import com.example.utppam.ui.theme.UTPPAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UTPPAMTheme {
                // State hoisting: mutableStateListOf owned at the top level,
                // passed down to all screens via AppNavigation
                val menuItems = remember {
                    mutableStateListOf(*sampleMenu.toTypedArray())
                }

                AppNavigation(
                    menuItems = menuItems,
                    onQuantityChange = { id, newQuantity ->
                        val index = menuItems.indexOfFirst { it.id == id }
                        if (index != -1) {
                            menuItems[index] = menuItems[index].copy(quantity = newQuantity)
                        }
                    },
                    onResetOrders = {
                        menuItems.indices.forEach { i ->
                            menuItems[i] = menuItems[i].copy(quantity = 0)
                        }
                    }
                )
            }
        }
    }
}
