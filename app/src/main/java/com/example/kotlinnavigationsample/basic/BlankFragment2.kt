package com.example.kotlinnavigationsample.basic

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinnavigationsample.R
import kotlinx.android.synthetic.main.fragment_blank_2.b2Text
import kotlinx.android.synthetic.main.fragment_blank_2.backBtn

class BlankFragment2 : Fragment() {
  private lateinit var listener: OnBackInteractionListener
  private val param1: Int by lazy { arguments?.getInt("param1") ?: -1 }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_blank_2, container, false)
  }

  @SuppressLint("SetTextI18n")
  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    b2Text.text = "Reached frag#2 with params: $param1"
    backBtn.setOnClickListener { v -> listener.onBack(v) }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnBackInteractionListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
    }
  }

  interface OnBackInteractionListener {
    fun onBack(view: View)
  }
}
