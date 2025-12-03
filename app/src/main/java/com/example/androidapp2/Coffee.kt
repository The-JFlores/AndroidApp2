package com.example.androidapp2

/**
 * Coffee.kt
 * Simple data class representing a coffee product.
 */

data class Coffee(
    val name: String,
    val shortDescription: String,
    val longDescription: String,
    val price: Double,
    val imageResId: Int
)