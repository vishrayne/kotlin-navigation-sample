package com.example.kotlinnavigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinnavigationsample.conditional.ProductDetailFragment
import com.example.kotlinnavigationsample.conditional.ProductListFragment
import com.example.kotlinnavigationsample.conditional.ProductListFragmentDirections

class ConditionalNavigationActivity : AppCompatActivity(),
    ProductListFragment.OnProductInteractionListener,
    ProductDetailFragment.OnProductDetailInteractionListener {
  private lateinit var conditionalArgNavController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_conditional_navigation)
    conditionalArgNavController =
        Navigation.findNavController(this, R.id.conditionalNavHostFragment)
  }

  override fun onProductInteraction(productID: Int) {
    ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment()
        .apply {
          setProductId(productID)
        }
        .apply(conditionalArgNavController::navigate)
  }

  override fun onProductDetailInteraction(
    productID: Int,
    count: Int
  ) {
    Log.d("ConditionalNavExample", "Product Selected: $productID [count: $count]")
  }
}
