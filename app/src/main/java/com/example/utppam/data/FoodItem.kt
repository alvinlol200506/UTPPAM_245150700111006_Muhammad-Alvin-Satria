package com.example.utppam.data

data class FoodItem(
    val id: Int,
    val name: String,
    val price: Int,
    val quantity: Int = 0
)

val sampleMenu = listOf(
    FoodItem(1, "Nasi Goreng", 15000),
    FoodItem(2, "Mie Ayam", 12000),
    FoodItem(3, "Soto Ayam", 13000),
    FoodItem(4, "Bakso", 14000),
    FoodItem(5, "Gado-Gado", 11000),
    FoodItem(6, "Rendang", 25000),
    FoodItem(7, "Ayam Bakar", 20000),
    FoodItem(8, "Es Teh Manis", 5000),
    FoodItem(9, "Jus Alpukat", 8000),
    FoodItem(10, "Pisang Goreng", 7000)
)
