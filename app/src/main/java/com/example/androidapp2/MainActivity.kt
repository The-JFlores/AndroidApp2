package com.example.androidapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * MainActivity.kt
 * Shows a list of coffee products using RecyclerView.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerCoffee: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerCoffee = findViewById(R.id.recyclerCoffee)
        recyclerCoffee.layoutManager = LinearLayoutManager(this)

        // Sample data — using the ic_coffee placeholder vector
        val sample = listOf(
            Coffee("Americano", "Hot espresso with water", "Classic Americano: double shot espresso and hot water.", 2.50, R.drawable.ic_coffee),
            Coffee("Latte", "Espresso with steamed milk", "Creamy latte with velvety milk foam.", 3.75, R.drawable.ic_coffee),
            Coffee("Iced Coffee", "Cold brewed", "Refreshing iced coffee with a hint of sweetness.", 2.95, R.drawable.ic_coffee)
        )

        val adapter = CoffeeAdapter(sample)
        recyclerCoffee.adapter = adapter
    }
}