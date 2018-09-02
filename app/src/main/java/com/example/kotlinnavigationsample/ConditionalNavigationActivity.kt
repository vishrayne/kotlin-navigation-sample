package com.example.kotlinnavigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinnavigationsample.conditional.ProductListFragment

class ConditionalNavigationActivity : AppCompatActivity(),
    ProductListFragment.OnProductInteractionListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_conditional_navigation)
  }

  override fun onProductInteraction(productID: Int) {
    Log.d("ConditionalNavExample", "product #$productID clicked")
  }
}
