package com.example.kotlinnavigationsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_drawer_navigation.drawerLayout
import kotlinx.android.synthetic.main.activity_drawer_navigation.drawerNavView
import kotlinx.android.synthetic.main.app_bar_drawer_navigation.toolbar

class DrawerNavigationActivity : AppCompatActivity() {
  companion object {
    fun getIntent(context: Context): Intent = Intent(context, DrawerNavigationActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_drawer_navigation)
    setSupportActionBar(toolbar)
    ActionBarDrawerToggle(
        this,
        drawerLayout,
        toolbar,
        R.string.navigation_drawer_open,
        R.string.navigation_drawer_close
    ).apply {
      drawerLayout.addDrawerListener(this)
      syncState()
    }

    Navigation.findNavController(this, R.id.drawerNavFragment)
        .also {
          NavigationUI.setupActionBarWithNavController(this, it, drawerLayout)
          NavigationUI.setupWithNavController(drawerNavView, it)
        }
  }

  override fun onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }
}
