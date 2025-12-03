package com.example.androidapp2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * CoffeeAdapter.kt
 * Adapter for RecyclerView showing coffee items.
 * On item click, opens DetailActivity using Intent extras.
 */

class CoffeeAdapter(private val items: List<Coffee>) : RecyclerView.Adapter<CoffeeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageCoffee: ImageView = view.findViewById(R.id.imageCoffee)
        val textName: TextView = view.findViewById(R.id.textCoffeeName)
        val textShort: TextView = view.findViewById(R.id.textCoffeeShort)
        val textPrice: TextView = view.findViewById(R.id.textCoffeePrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coffee, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coffee = items[position]
        holder.imageCoffee.setImageResource(coffee.imageResId)
        holder.textName.text = coffee.name
        holder.textShort.text = coffee.shortDescription
        holder.textPrice.text = String.format("$%.2f", coffee.price)

        // On click open DetailActivity and pass coffee data via Intent extras.
        holder.itemView.setOnClickListener {
            val ctx = it.context
            val intent = Intent(ctx, DetailActivity::class.java).apply {
                putExtra("name", coffee.name)
                putExtra("short", coffee.shortDescription)
                putExtra("long", coffee.longDescription)
                putExtra("price", coffee.price)
                putExtra("image", coffee.imageResId)
            }
            ctx.startActivity(intent)
        }
    }
}