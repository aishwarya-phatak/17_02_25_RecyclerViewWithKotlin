package com.bitcode.a17_02_25_recyclerviewwithkotlin

import android.content.Intent
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.a17_02_25_recyclerviewwithkotlin.databinding.ProductViewHolderBinding
import com.bitcode.a17_02_25_recyclerviewwithkotlin.databinding.UserViewHolderBinding

class NewAdapter(
    private var products : ArrayList<Product>,
    private var users : ArrayList<User>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val USER_VIEW_HOLDER = 1
    private val PRODUCT_VIEW_HOLDER = 2

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private lateinit var imageView1 : ImageView
        private lateinit var txtViewTitle : TextView
        var productViewHolderBinding = ProductViewHolderBinding.bind(itemView)

        init {
            Log.e("tag", "init block of PVH called")

            productViewHolderBinding.imageView1.setOnClickListener {

                //way 2
                var intent = Intent(itemView.context, ProductDetailsActivity::class.java)
                var product = products[adapterPosition]
                intent.putExtra("product",product)
                itemView.context.startActivity(intent)

                //way 1
//                var intent = Intent(itemView.context, ProductDetailsActivity::class.java)
//                intent.putExtra("title", productViewHolderBinding.textViewTitle.text)
//                intent.putExtra("price",productViewHolderBinding.textViewPrice.text)
//                itemView.context.startActivity(intent)
            }
        }
    }

    inner class MyBtnClickListener : View.OnClickListener{
        override fun onClick(v: View?) {
            Log.e("tag", "onClick method called")
        }
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var userViewHolderBinding = UserViewHolderBinding.bind(itemView)  //bind
            init {
                Log.e("tag", "init block of UVH called")
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            var userViewHolderBinding: UserViewHolderBinding

            var layoutInflater = LayoutInflater.from(parent.context)
            userViewHolderBinding = UserViewHolderBinding.inflate(layoutInflater)

            var userView = userViewHolderBinding.root
            return UserViewHolder(userView)
        }  else {
            var productViewHolderBinding = ProductViewHolderBinding
                .inflate(LayoutInflater.from(parent.context))

            //way 1 - inner class object
//            productViewHolderBinding.imageView1.setOnClickListener(MyBtnClickListener())

            //way 2 - using own argument x instead of it
//            productViewHolderBinding.imageView1.setOnClickListener{ x ->
//                if (x is ImageView){
//                    Toast.makeText(parent.context,"lambda function",Toast.LENGTH_LONG).show()
//                }
//            }

            //way 3 - by using it keyword
//            productViewHolderBinding.imageView1.setOnClickListener{
//                Toast.makeText(parent.context,"$it",Toast.LENGTH_LONG).show()
//            }

            return ProductViewHolder(productViewHolderBinding.root)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder){
            holder.userViewHolderBinding.textViewName.text = users[position/3].username
            Log.e("tag", "onbind inside holder")
        }
        if(holder is ProductViewHolder){
            holder.productViewHolderBinding.imageView1.
                 setImageResource(R.drawable.ic_launcher_background)

            holder.productViewHolderBinding.textViewTitle.text = products[position - (position/3)].title
            holder.productViewHolderBinding.textViewPrice.text = products[position - (position/3)].price.toString()
        }
    }

    override fun getItemCount(): Int {
        return products.size + users.size
    }

    override fun getItemViewType(position: Int): Int {
       return if (((position + 1)%3) == 0){
                USER_VIEW_HOLDER
       } else {
            PRODUCT_VIEW_HOLDER
       }
    }
}