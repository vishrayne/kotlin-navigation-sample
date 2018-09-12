package com.example.kotlinnavigationsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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

  override fun onLoginSuccess(userName: String) {
    conditionalArgNavController.popBackStack()
  }

  override fun loginCancelled() {
    conditionalArgNavController.popBackStack(R.id.productListFragment, false)
  }
}
