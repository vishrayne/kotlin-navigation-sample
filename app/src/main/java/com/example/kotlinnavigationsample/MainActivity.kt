package com.example.kotlinnavigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinnavigationsample.basic.BasicNavigationActivity
import com.example.kotlinnavigationsample.bottomnav.BottomNavigationActivity
import kotlinx.android.synthetic.main.activity_main.basicNavButton
import kotlinx.android.synthetic.main.activity_main.bottomNavButton

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

  }

}
