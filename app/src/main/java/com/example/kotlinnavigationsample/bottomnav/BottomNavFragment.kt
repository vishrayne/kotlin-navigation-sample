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
  private val iconId: Int by lazy { arguments?.getInt("icon_id") ?: R.mipmap.ic_launcher_round }
  private val label: String by lazy { arguments?.getString("label") ?: "Empty" }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_bottom_nav, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    bottomNavTextView.text = label
    bottomNavImageView.setImageResource(iconId)
  }
}
