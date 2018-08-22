package com.example.kotlinnavigationsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.kotlinnavigationsample.common.PlaceHolderFragment
import com.example.kotlinnavigationsample.common.PlaceHolderFragment.Action.BACK
import com.example.kotlinnavigationsample.common.PlaceHolderFragment.Action.NEXT

class BasicNavigationActivity : AppCompatActivity(), PlaceHolderFragment.OnActionListener {
  companion object {
    fun getIntent(context: Context): Intent = Intent(context, BasicNavigationActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_basic_navigation)
  }

  override fun onAction(
    actionLabel: String,
    view: View
  ) = when (actionLabel) {
    NEXT -> onNext(view)
    BACK -> onBack(view)
    else -> throw RuntimeException("Undefined action $actionLabel for PlaceHolderFragment")
  }

}

// -- For a change, onBack and OnNext are extension functions -- //

private fun onBack(view: View) {
  Navigation.findNavController(view)
      .navigateUp()
}

private fun onNext(view: View) {
  Navigation.findNavController(view)
      .navigate(
          R.id.action_navigation_next_to_navigation_back,
          bundleOf(
              "has_custom_params" to true,
              "custom_arg" to "Kryptonian"
          )
      )
}
