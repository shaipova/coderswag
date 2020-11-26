package com.example.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.Adapters.ProductsAdapter
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import com.example.coderswag.Utilities.EXTRA_PRODUCT
import com.example.coderswag.Utilities.EXTRA_PRODUCT_IMAGE
import com.example.coderswag.Utilities.EXTRA_PRODUCT_PRICE
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)!!
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) {product ->
            val infoIntent = Intent(this, InfoActivity::class.java)
            infoIntent.putExtra(EXTRA_PRODUCT, product.title)
            infoIntent.putExtra(EXTRA_PRODUCT_PRICE, product.price)
            infoIntent.putExtra(EXTRA_PRODUCT_IMAGE, product.image)
            startActivity(infoIntent)
        }

        // количество колонок с продуктами
        var spanCount = 2

        // если повернуть устройство горизонтально, то колонок будет 4
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4
        }

        // если устройство большое, то колонок будет 3 в любой ориентации
        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}