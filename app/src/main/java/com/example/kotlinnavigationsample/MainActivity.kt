package com.example.kotlinnavigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kotlinnavigationsample.common.MainFragment

class MainActivity : AppCompatActivity(), MainFragment.OnItemInteractionListener {
  private lateinit var mainNavController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    mainNavController = Navigation.findNavController(this, R.id.mainNavFragment)
  }

  override fun onItemInteraction(itemID: Int) {
    when (itemID) {
      MainFragment.BASIC_NAV -> R.id.action_mainFragment_to_basicNavigationActivity
      MainFragment.BOTTOM_NAV -> R.id.action_mainFragment_to_bottomNavigationActivity
      MainFragment.DRAWER_NAV -> R.id.action_mainFragment_to_drawerNavigationActivity
      MainFragment.DEEP_NAV -> R.id.action_mainFragment_to_deepLinkNavigationActivity
      else -> throw RuntimeException("Invalid Example: $itemID")
    }.apply(mainNavController::navigate)
  }
}
