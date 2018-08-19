package com.example.kotlinnavigationsample.basic

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinnavigationsample.R
import kotlinx.android.synthetic.main.fragment_blank_1.nextBtn

class BlankFragment1 : Fragment() {
  private lateinit var listener: OnNextInteractionListener

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_blank_1, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    nextBtn.setOnClickListener { v -> listener.onNext(v); }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnNextInteractionListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
    }
  }

  interface OnNextInteractionListener {
    fun onNext(view: View)
  }
}
