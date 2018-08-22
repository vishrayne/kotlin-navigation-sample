package com.example.kotlinnavigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.basicNavButton
import kotlinx.android.synthetic.main.activity_main.bottomNavButton
import kotlinx.android.synthetic.main.activity_main.drawerNavButton

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    basicNavButton.setOnClickListener {
      startActivity(BasicNavigationActivity.getIntent(this@MainActivity))
    }

    bottomNavButton.setOnClickListener {
      startActivity(BottomNavigationActivity.getIntent(this@MainActivity))
    }

    drawerNavButton.setOnClickListener {
      startActivity(DrawerNavigationActivity.getIntent(this@MainActivity))
    }
  }

}
