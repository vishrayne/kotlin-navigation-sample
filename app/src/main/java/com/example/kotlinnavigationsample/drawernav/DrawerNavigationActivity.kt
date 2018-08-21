package com.example.kotlinnavigationsample.drawernav

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.kotlinnavigationsample.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_drawer_navigation.drawerLayout
import kotlinx.android.synthetic.main.activity_drawer_navigation.drawerNavView
import kotlinx.android.synthetic.main.app_bar_drawer_navigation.toolbar

class DrawerNavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
  companion object {
    fun getIntent(context: Context): Intent = Intent(context, DrawerNavigationActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_drawer_navigation)
    setSupportActionBar(toolbar)

    val toggle = ActionBarDrawerToggle(
        this, drawerLayout, toolbar, R.string.navigation_drawer_open,
        R.string.navigation_drawer_close)
    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()

    drawerNavView.setNavigationItemSelectedListener(this)
  }

  override fun onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    // Handle navigation view item clicks here.
    when (item.itemId) {
      R.id.nav_camera -> {
        // Handle the camera action
      }
      R.id.nav_gallery -> {

      }
      R.id.nav_slideshow -> {

      }
      R.id.nav_manage -> {

      }
      R.id.nav_share -> {

      }
      R.id.nav_send -> {

      }
    }

    drawerLayout.closeDrawer(GravityCompat.START)
    return true
  }
}
