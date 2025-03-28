package com.bitcode.a17_02_25_recyclerviewwithkotlin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bitcode.a17_02_25_recyclerviewwithkotlin.databinding.ProductDetailsActivityBinding

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var productDetailsActivityBinding: ProductDetailsActivityBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productDetailsActivityBinding = ProductDetailsActivityBinding
            .inflate(layoutInflater)
        setContentView(productDetailsActivityBinding.root)
        extractData()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun extractData(){
        var i = intent
        var bundle = i.extras
        var product = bundle?.getSerializable("product",Product::class.java)
        if (product != null) {
            Log.e("tag", "${product.title}   -- ${product.price}")
        }

        //way 1
//        var i = intent
//        var bundle = i.extras
//        var title = bundle?.getString("title")
//        var price = bundle?.getString("price")
//        Log.e("tag", "title - $title  --- price - $price")
    }
}