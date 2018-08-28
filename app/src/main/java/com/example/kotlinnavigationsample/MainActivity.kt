package com.example.kotlinnavigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinnavigationsample.common.MainFragment

class MainActivity : AppCompatActivity(), MainFragment.OnItemInteractionListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  override fun onItemInteraction(itemID: Int) {
    when (itemID) {
      MainFragment.BASIC_NAV -> BasicNavigationActivity.getIntent(this)
      MainFragment.BOTTOM_NAV -> BottomNavigationActivity.getIntent(this)
      MainFragment.DRAWER_NAV -> DrawerNavigationActivity.getIntent(this)
      MainFragment.DEEP_NAV -> DeepLinkNavigationActivity.getIntent(this)
      else -> throw RuntimeException("Invalid Example: $itemID")
    }.apply(::startActivity)
  }
}
