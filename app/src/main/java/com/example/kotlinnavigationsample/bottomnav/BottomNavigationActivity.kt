package com.example.kotlinnavigationsample.bottomnav

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinnavigationsample.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {
  companion object {
    fun getIntent(context: Context): Intent = Intent(context, BottomNavigationActivity::class.java)
  }

  private val mOnNavigationItemSelectedListener =
    BottomNavigationView.OnNavigationItemSelectedListener { item ->
      return@OnNavigationItemSelectedListener when (item.itemId) {
        R.id.navigation_home -> {
          message.setText(R.string.title_home)
          true
        }
        R.id.navigation_dashboard -> {
          message.setText(R.string.title_dashboard)
          true
        }
        R.id.navigation_notifications -> {
          message.setText(R.string.title_notifications)
          true
        }
        else -> false
      }
    }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_bottom_navigation)
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
  }
}
