package com.example.kotlinnavigationsample.basic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinnavigationsample.R
import com.example.kotlinnavigationsample.common.PlaceHolderFragment
import com.example.kotlinnavigationsample.common.PlaceHolderFragment.Action.BACK
import com.example.kotlinnavigationsample.common.PlaceHolderFragment.Action.NEXT
import kotlinx.android.synthetic.main.activity_basic_navigation.basicNavHostFragment

class BasicNavigationActivity : AppCompatActivity(), PlaceHolderFragment.OnActionListener {
  companion object {
    fun getIntent(context: Context): Intent = Intent(context, BasicNavigationActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_basic_navigation)

    // The default layout:navGraph methods doesn't allow us to pass args to the start destination,
    // so I had to manually inflate the graph with the required args.
    val navHostFragment = basicNavHostFragment as NavHostFragment
    navHostFragment.navController.graph =
        navHostFragment.navController.navInflater.inflate(R.navigation.basic_navigation)
            .apply {
              addDefaultArguments(
                  bundleOf("label" to PlaceHolderFragment.NEXT)
              )
            }
  }

  override fun onAction(
    actionLabel: String,
    view: View
  ) = when (actionLabel) {
    NEXT -> onNext(view)
    BACK -> onBack(view)
    else -> throw RuntimeException("Undefined action $actionLabel for PlaceHolderFragment")
  }

  private fun onNext(view: View) {
    val b = bundleOf(
        "label" to BACK
    )

    Navigation.findNavController(view)
        .navigate(R.id.action_navigation_next_to_navigation_back, b)
  }

  private fun onBack(view: View) {
    Navigation.findNavController(view)
        .navigateUp()
  }
}
