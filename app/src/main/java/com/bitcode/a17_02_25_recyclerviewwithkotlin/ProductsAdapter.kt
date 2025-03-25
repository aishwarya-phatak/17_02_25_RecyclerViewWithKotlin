package com.bitcode.a17_02_25_recyclerviewwithkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private var products : ArrayList<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

        inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var imageView1 : ImageView = itemView.findViewById(R.id.imageView1)
            var textViewTitle : TextView = itemView.findViewById(R.id.textViewTitle)
            var textViewPrice : TextView = itemView.findViewById(R.id.textViewPrice)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var productView = layoutInflater.inflate(R.layout.product_view_holder,null)
        var imageView1 : ImageView = productView.findViewById(R.id.imageView1)
        var textViewTitle : TextView = productView.findViewById(R.id.textViewTitle)
        var textViewPrice : TextView = productView.findViewById(R.id.textViewPrice)

        return ProductViewHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            holder.imageView1.setImageResource(R.drawable.ic_launcher_background)
            holder.textViewTitle.text = products[position].title
            holder.textViewPrice.text = "${products[position].price}"
    }

    override fun getItemCount(): Int {
        return products.size
    }
}