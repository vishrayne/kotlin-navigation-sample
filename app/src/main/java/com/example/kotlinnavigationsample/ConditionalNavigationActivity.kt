package com.example.kotlinnavigationsample

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinnavigationsample.conditional.LoginFragment
import com.example.kotlinnavigationsample.conditional.ProductDetailFragment
import com.example.kotlinnavigationsample.conditional.ProductListFragment
import com.example.kotlinnavigationsample.conditional.ProductListFragmentDirections

class ConditionalNavigationActivity : AppCompatActivity(),
    ProductListFragment.OnProductInteractionListener,
    ProductDetailFragment.OnProductDetailInteractionListener,
    LoginFragment.OnLoginInteractionListener {
  private lateinit var conditionalArgNavController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_conditional_navigation)
    conditionalArgNavController =
        Navigation.findNavController(this, R.id.conditionalNavHostFragment)

  }

  override fun onSupportNavigateUp(): Boolean =
    conditionalArgNavController.navigateUp() || super.onSupportNavigateUp()

  override fun onProductInteraction(productID: Int) {
    ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment()
        .apply {
          setProductId(productID)
        }
        .apply(conditionalArgNavController::navigate)
  }

  override fun requestLogin(actionID: Int) {
    conditionalArgNavController.navigate(actionID)
  }

  override fun onProductDetailInteraction(
    productID: Int,
    count: Int
  ) {
    Log.d("ConditionalNavExample", "Product Selected: $productID [count: $count]")
  }

  override fun onLoginInteraction(userName: String) {
    conditionalArgNavController.navigateUp()
  }
}
