package com.example.kotlinnavigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinnavigationsample.main.Example
import com.example.kotlinnavigationsample.main.MainFragment

class MainActivity : AppCompatActivity(), MainFragment.OnItemInteractionListener {
  private lateinit var mainNavController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    mainNavController = Navigation.findNavController(this, R.id.mainNavFragment)
  }

  override fun onItemInteraction(itemID: Int) {
    when (itemID) {
      Example.BASIC_NAV -> R.id.action_mainFragment_to_basicNavigationActivity
      Example.BOTTOM_NAV -> R.id.action_mainFragment_to_bottomNavigationActivity
      Example.DRAWER_NAV -> R.id.action_mainFragment_to_drawerNavigationActivity
      Example.DEEP_NAV -> R.id.action_mainFragment_to_deepLinkNavigationActivity
      Example.SAFE_ARGS -> R.id.action_mainFragment_to_safeArgsNavigationActivity
      else -> throw RuntimeException("Invalid Example: $itemID")
    }.apply(mainNavController::navigate)
  }

  override fun onSupportNavigateUp(): Boolean = mainNavController.navigateUp()
}
