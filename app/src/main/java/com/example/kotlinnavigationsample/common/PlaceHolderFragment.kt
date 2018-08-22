package com.example.kotlinnavigationsample.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinnavigationsample.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_place_holder.actionBtn
import kotlinx.android.synthetic.main.fragment_place_holder.textView
import kotlinx.android.synthetic.main.fragment_place_holder.vectorImageView

class PlaceHolderFragment : Fragment() {
  companion object Action {
    const val NEXT = "next"
    const val BACK = "back"
    const val HOME = "home"
    const val DASHBOARD = "dashboard"
    const val NOTIFICATIONS = "notification"
    const val NONE = "none" // no-op response code
  }

  interface OnActionListener {
    fun onAction(
      actionLabel: String,
      view: View
    )
  }

  private lateinit var listener: OnActionListener
  private val label: String by lazy { arguments?.getString("label") ?: "" }
  private val hasCustomArgs: Boolean by lazy {
    arguments?.getBoolean("has_custom_params") ?: false
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_place_holder, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    val (tag, iconID, action) = assetPackFor(label)
    vectorImageView.setImageResource(iconID)
    textView.text = tag

    if (action == NONE) {
      actionBtn.visibility = View.GONE
    } else {
      actionBtn.visibility = View.VISIBLE
      attachAction(context, action)
    }

    if (hasCustomArgs) {
      with(arguments?.getString("custom_arg") ?: "Bad_Key") {
        Snackbar.make(view, "Custom Argument: $this", Snackbar.LENGTH_SHORT)
            .show()
      }
    }
  }

  private fun attachAction(
    context: Context?,
    action: String
  ) {
    if (context !is OnActionListener) {
      throw RuntimeException(context.toString() + " must implement OnActionListener")
    }

    listener = context
    actionBtn.text = action
    actionBtn.setOnClickListener { listener.onAction(action, it) }
  }

  private fun assetPackFor(label: String): Triple<String, Int, String> {
    return when (label) {
      NEXT -> Triple("Partial#1", R.drawable.ic_home_black_24dp, NEXT)
      BACK -> Triple("Partial#2", R.drawable.ic_notifications_black_24dp, BACK)
      HOME -> Triple("Home", R.drawable.ic_home_black_24dp, NONE)
      DASHBOARD -> Triple("Dashboard", R.drawable.ic_dashboard_black_24dp, NONE)
      NOTIFICATIONS -> Triple("Notification", R.drawable.ic_notifications_black_24dp, NONE)
      else -> Triple("Unknown", R.drawable.ic_launcher_background, NONE)
    }
  }
}
