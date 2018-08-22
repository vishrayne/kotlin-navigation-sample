package com.example.kotlinnavigationsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_bottom_navigation.bottomNavigation

class BottomNavigationActivity : AppCompatActivity() {
  private lateinit var navController: NavController

  companion object {
    fun getIntent(context: Context): Intent = Intent(context, BottomNavigationActivity::class.java)
  }

  override fun onSupportNavigateUp() = navController.navigateUp()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bottom_navigation)
    navController = Navigation.findNavController(this, R.id.bottomNavFragment)

    NavigationUI.setupActionBarWithNavController(this, navController)
    NavigationUI.setupWithNavController(bottomNavigation, navController)
  }
}
