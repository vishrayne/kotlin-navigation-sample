package com.example.kotlinnavigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_bottom_navigation.bottomNavigation

class BottomNavigationActivity : AppCompatActivity() {
  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bottom_navigation)
    navController = Navigation.findNavController(this, R.id.bottomNavFragment)
        .also {
          NavigationUI.setupActionBarWithNavController(this, it)
          NavigationUI.setupWithNavController(bottomNavigation, it)
        }
  }

  override fun onSupportNavigateUp() = navController.navigateUp()
}
