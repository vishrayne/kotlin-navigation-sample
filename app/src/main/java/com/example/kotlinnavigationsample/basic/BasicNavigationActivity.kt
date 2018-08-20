package com.example.kotlinnavigationsample.basic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.kotlinnavigationsample.R

class BasicNavigationActivity : AppCompatActivity(), BlankFragment1.OnNextInteractionListener,
    BlankFragment2.OnBackInteractionListener {
  companion object {
    fun getIntent(context: Context): Intent = Intent(context, BasicNavigationActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_basic_navigation)
  }

  override fun onNext(view: View) {
    val b = bundleOf(
        "param1" to 1,
        "param2" to 2
    )

    Navigation.findNavController(view)
        .navigate(R.id.action_blankFragment1_to_blankFragment2, b)
  }

  override fun onBack(view: View) {
    Navigation.findNavController(view)
        .navigateUp()
  }
}
