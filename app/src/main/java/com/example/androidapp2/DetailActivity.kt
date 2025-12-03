package com.example.androidapp2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * DetailActivity.kt
 * Displays details for a selected coffee product. Receives fields through Intent extras.
 */

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView = findViewById<ImageView>(R.id.imageDetail)
        val textName = findViewById<TextView>(R.id.textNameDetail)
        val textPrice = findViewById<TextView>(R.id.textPriceDetail)
        val textDescription = findViewById<TextView>(R.id.textDescriptionDetail)
        val buttonOrder = findViewById<Button>(R.id.buttonOrder)

        // Get extras passed via Intent
        val name = intent.getStringExtra("name") ?: "Unknown"
        val short = intent.getStringExtra("short") ?: ""
        val longDesc = intent.getStringExtra("long") ?: ""
        val price = intent.getDoubleExtra("price", 0.0)
        val imageRes = intent.getIntExtra("image", R.drawable.ic_coffee)

        // Populate views
        imageView.setImageResource(imageRes)
        textName.text = name
        textPrice.text = String.format("$%.2f", price)
        textDescription.text = "$short\n\n$longDesc"

        buttonOrder.setOnClickListener {
            // For now show a simple Toast or implement ordering flow.
            android.widget.Toast.makeText(this, "Order placed for $name", android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}