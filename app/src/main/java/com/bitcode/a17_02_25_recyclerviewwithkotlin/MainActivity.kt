package com.bitcode.a17_02_25_recyclerviewwithkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.a17_02_25_recyclerviewwithkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var products : ArrayList<Product>
    private lateinit var users : ArrayList<User>
    private lateinit var recyclerView: RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var newAdapter: NewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        initArrayList()
        initViews()
    }

    private fun initViews(){
//      recyclerView = findViewById(R.id.recyclerViewForProducts)
        productsAdapter = ProductsAdapter(products, users)
        newAdapter = NewAdapter(products,users)

        activityMainBinding.recyclerViewForProducts.adapter = newAdapter
        activityMainBinding.recyclerViewForProducts.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

//        recyclerView.adapter = productsAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this,
//            LinearLayoutManager.VERTICAL,
//            false)
    }

    private fun initArrayList(){
        products = ArrayList<Product>()

        for (i in 1..10){
            products.add(Product(
                i,
                "Product - $i",
                i * 500 + 1000)
            )
        }

        users = ArrayList<User>()

        for (i in 1..10) {
            users.add(User("User + $i"))
        }
    }
}