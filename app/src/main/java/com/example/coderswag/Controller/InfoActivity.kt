package com.example.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coderswag.R
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import com.example.coderswag.Utilities.EXTRA_PRODUCT
import com.example.coderswag.Utilities.EXTRA_PRODUCT_IMAGE
import com.example.coderswag.Utilities.EXTRA_PRODUCT_PRICE
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val productType = intent.getStringExtra(EXTRA_PRODUCT)!!
        val productPrice = intent.getStringExtra(EXTRA_PRODUCT_PRICE)
        val infoImageStr = intent.getStringExtra(EXTRA_PRODUCT_IMAGE)

        infoName.text = productType
        infoPrice.text = productPrice


        val resourceId = this.resources.getIdentifier(infoImageStr,
            "drawable", this.packageName)

        infoImage.setImageResource(resourceId)
    }

}