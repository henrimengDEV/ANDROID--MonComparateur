package com.example.my_first_app.element

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.my_first_app.R
import com.example.my_first_app.model.Product
import com.squareup.picasso.Picasso

class ProductRecyclerAdapter(private val products: List<Product>): RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val currentItem: CardView = itemView.findViewById(R.id.product_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.currentItem.setOnClickListener {
            val bundle = bundleOf("product" to products[position])
            Navigation.findNavController(it)
                .navigate(R.id.action_productsListFragment_to_productDetailsFragment, bundle)
        }

        Picasso.get().load(products[position].urlImg).fit().centerCrop()
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(holder.currentItem.findViewById<ImageView>(R.id.product_details_img))
        holder.currentItem.findViewById<TextView>(R.id.product_card_name).text = products[position].name
        holder.currentItem.findViewById<TextView>(R.id.product_card_brand).text = products[position].brand
        holder.currentItem.findViewById<TextView>(R.id.product_card_nutriscore).text = "Nutriscore : " + products[position].score
        holder.currentItem.findViewById<TextView>(R.id.product_card_calories).text = "${products[position].nutrientLevels?.calories?.quantityPerPortion} kCal/part"
    }

    override fun getItemCount(): Int {
        return products.size
    }
}