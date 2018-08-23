package com.example.kotlinnavigationsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinnavigationsample.common.PlaceHolderFragment
import com.google.android.material.snackbar.Snackbar

class DeepLinkNavigationActivity : AppCompatActivity(), PlaceHolderFragment.OnActionListener {
  companion object {
    fun getIntent(context: Context): Intent = Intent(
        context,
        DeepLinkNavigationActivity::class.java
    )
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_deep_link_navigation)
  }

  override fun onAction(
    actionLabel: String,
    view: View,
    args: Bundle?
  ) {
    with(args?.getString("deep_arg") ?: "") {
      val message = when {
        this.isEmpty() ->
          "Visit www.example.co.in/{query} from any in-app browser of your choice"
        else -> "DeepLinkArg: $this"
      }

      Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
          .also { snack ->
            snack.setAction("close") { snack.dismiss() }
          }
          .show()
    }
  }
}
