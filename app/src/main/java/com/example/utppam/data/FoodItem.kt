package com.example.utppam.data

data class FoodItem(
    val id: Int,
    val name: String,
    val price: Int,
    val description: String,
    val quantity: Int = 0
)

val sampleMenu = listOf(
    FoodItem(
        id = 1,
        name = "Nasi Goreng",
        price = 15000,
        description = "Nasi yang digoreng bersama kecap manis, bawang putih, cabai, dan telur ceplok di atasnya. Disajikan dengan acar timun dan kerupuk. Salah satu ikon kuliner Indonesia yang populer di semua kalangan."
    ),
    FoodItem(
        id = 2,
        name = "Mie Ayam",
        price = 12000,
        description = "Mie kuning kenyal dengan topping ayam cincang berbumbu kecap, sawi hijau rebus, dan bakso. Kuahnya ringan dari kaldu ayam yang gurih. Biasanya disajikan dengan sambal dan acar."
    ),
    FoodItem(
        id = 3,
        name = "Soto Ayam",
        price = 13000,
        description = "Sup bening kuning berbahan ayam suwir dengan bumbu kunyit, serai, daun jeruk, dan jahe. Disajikan dengan soun, telur rebus, tomat, dan taburan bawang goreng. Cocok dinikmati pagi hari."
    ),
    FoodItem(
        id = 4,
        name = "Bakso",
        price = 14000,
        description = "Bola daging sapi halus yang kenyal dalam kuah kaldu bening beraroma kuat. Disajikan dengan mie kuning, bihun, tahu, dan taburan bawang goreng. Salah satu jajanan paling dicari di Indonesia."
    ),
    FoodItem(
        id = 5,
        name = "Gado-Gado",
        price = 11000,
        description = "Sayuran rebus seperti kangkung, kacang panjang, tauge, dan kentang disiram saus kacang kental yang gurih manis. Dilengkapi telur rebus, tahu, tempe, dan kerupuk. Pilihan sehat dan mengenyangkan."
    ),
    FoodItem(
        id = 6,
        name = "Rendang",
        price = 25000,
        description = "Daging sapi yang dimasak perlahan berjam-jam dalam santan kental dan campuran rempah lengkap seperti lengkuas, serai, cabai, dan daun kunyit. Menghasilkan tekstur kering beraroma kuat. Masakan Minang yang mendunia."
    ),
    FoodItem(
        id = 7,
        name = "Ayam Bakar",
        price = 20000,
        description = "Ayam yang diungkep dengan bumbu rempah kemudian dibakar di atas bara api hingga kulitnya sedikit kecokelatan dan harum. Disajikan dengan lalapan segar, sambal terasi, dan nasi putih hangat."
    ),
    FoodItem(
        id = 8,
        name = "Es Teh Manis",
        price = 5000,
        description = "Teh hitam pekat yang diseduh panas lalu dituang ke dalam gelas berisi es batu. Gula pasir ditambahkan sesuai selera. Minuman sederhana yang menyegarkan dan cocok menemani makanan apapun."
    ),
    FoodItem(
        id = 9,
        name = "Jus Alpukat",
        price = 8000,
        description = "Alpukat matang pilihan diblender bersama susu kental manis, sedikit gula, dan es batu hingga lembut dan creamy. Kaya lemak sehat dan vitamin E. Minuman favorit yang mengenyangkan sekaligus menyegarkan."
    ),
    FoodItem(
        id = 10,
        name = "Pisang Goreng",
        price = 7000,
        description = "Pisang kepok matang dibalut adonan tepung renyah dengan sedikit garam dan vanili, lalu digoreng hingga berwarna keemasan. Renyah di luar, lembut dan manis di dalam. Cocok sebagai camilan sore hari."
    )
)
