package com.example.kotlinnavigationsample.bottomnav


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinnavigationsample.R
import kotlinx.android.synthetic.main.fragment_bottom_nav.bottomNavImageView
import kotlinx.android.synthetic.main.fragment_bottom_nav.bottomNavTextView

class BottomNavFragment : Fragment() {
  private val label: String by lazy { arguments?.getString("label") ?: "" }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_bottom_nav, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val (tag, iconID) = assetPackFor(label)
    bottomNavTextView.text = tag
    bottomNavImageView.setImageResource(iconID)
  }

  private fun assetPackFor(label: String): Pair<String, Int> {
    return when (label) {
      "home" -> Pair("Home", R.drawable.ic_home_black_24dp)
      "dashboard" -> Pair("Dashboard", R.drawable.ic_dashboard_black_24dp)
      "notification" -> Pair("Notification", R.drawable.ic_notifications_black_24dp)
      else -> Pair("Unknown", R.drawable.ic_launcher_background)
    }
  }
}
