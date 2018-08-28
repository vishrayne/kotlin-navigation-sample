package com.example.kotlinnavigationsample.common

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kotlinnavigationsample.R
import kotlinx.android.synthetic.main.fragment_main.basicNavButton
import kotlinx.android.synthetic.main.fragment_main.bottomNavButton
import kotlinx.android.synthetic.main.fragment_main.deepNavButton
import kotlinx.android.synthetic.main.fragment_main.drawerNavButton

class MainFragment : Fragment() {
  companion object {
    const val BASIC_NAV = 0;
    const val BOTTOM_NAV = 1;
    const val DRAWER_NAV = 2;
    const val DEEP_NAV = 3;
  }

  private lateinit var listener: OnItemInteractionListener

  interface OnItemInteractionListener {
    fun onItemInteraction(itemID: Int)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_main, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    basicNavButton.setOnClickListener {
      listener.onItemInteraction(BASIC_NAV)
    }

    bottomNavButton.setOnClickListener {
      listener.onItemInteraction(BOTTOM_NAV)
    }

    drawerNavButton.setOnClickListener {
      listener.onItemInteraction(DRAWER_NAV)
    }

    deepNavButton.setOnClickListener {
      listener.onItemInteraction(DEEP_NAV)
    }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnItemInteractionListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
    }
  }

}
