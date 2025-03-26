package com.bitcode.a17_02_25_recyclerviewwithkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ProductsAdapter(private var products : ArrayList<Product>,
                      private var users : ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        val PRODUCT_VIEW_HOLDER = 1
        val USER_VIEW_HOLDER = 2

        inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var imageView1 : ImageView = itemView.findViewById(R.id.imageView1)
            var textViewTitle : TextView = itemView.findViewById(R.id.textViewTitle)
            var textViewPrice : TextView = itemView.findViewById(R.id.textViewPrice)
        }

        inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var textViewUsername : TextView = itemView.findViewById(R.id.textViewName)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType ==  PRODUCT_VIEW_HOLDER) {
            var layoutInflater = LayoutInflater.from(parent.context)
            var productView = layoutInflater.inflate(R.layout.product_view_holder, null)
            var imageView1: ImageView = productView.findViewById(R.id.imageView1)
            var textViewTitle: TextView = productView.findViewById(R.id.textViewTitle)
            var textViewPrice: TextView = productView.findViewById(R.id.textViewPrice)

            return ProductViewHolder(productView)
        } else {
            var layoutInflater = LayoutInflater.from(parent.context)
            var userView = layoutInflater.inflate(R.layout.user_view_holder, null)
            var textViewName: TextView = userView.findViewById(R.id.textViewName)

            return UserViewHolder(userView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder){
            var position1 = ((position - 1)/2)
            holder.imageView1.setImageResource(R.drawable.ic_launcher_background)
            holder.textViewTitle.text = products[position1].title
            holder.textViewPrice.text = "${products[position1].price}"
        }
        if (holder is UserViewHolder){
            var position2 = (position/2)
            holder.textViewUsername.text = users[position2].username
        }
    }

    override fun getItemCount(): Int {
        return products.size + users.size
    }

    override fun getItemViewType(position: Int): Int {
        if(position%2 == 0){
            return USER_VIEW_HOLDER
        } else {
            return PRODUCT_VIEW_HOLDER
        }
    }
}