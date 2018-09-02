package com.example.kotlinnavigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinnavigationsample.safeargs.ConfirmInputFragment
import com.example.kotlinnavigationsample.safeargs.InputDetailsFragment
import com.example.kotlinnavigationsample.safeargs.InputDetailsFragmentDirections

class SafeArgsNavigationActivity : AppCompatActivity(),
    InputDetailsFragment.OnInputListener,
    ConfirmInputFragment.OnConfirmInputListener {
  private lateinit var safeArgNavController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_safe_args_navigation)
    safeArgNavController = Navigation.findNavController(this, R.id.safeArgNavHostFragment)
  }

  override fun onSupportNavigateUp(): Boolean =
    safeArgNavController.navigateUp() || super.onSupportNavigateUp()

  override fun onInput(
    name: String,
    amount: Int,
    remember: Boolean
  ) {
    InputDetailsFragmentDirections.actionNavigationSafeInputToNavigationSafeShow()
        .apply {
          setName(name)
          setAmount(amount)
          setRememberChoice(remember)
        }
        .apply(safeArgNavController::navigate)
  }

  override fun onConfirmInput(boolean: Boolean) {
    safeArgNavController.popBackStack()
  }
}
