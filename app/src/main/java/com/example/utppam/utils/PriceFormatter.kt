package com.example.utppam.utils

fun Int.formatRupiah(): String {
    return "Rp " + "%,d".format(this).replace(',', '.')
}
