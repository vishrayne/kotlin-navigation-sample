package com.example.kotlinnavigationsample.safeargs

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kotlinnavigationsample.R
import com.example.kotlinnavigationsample.util.asInt
import com.example.kotlinnavigationsample.util.asString
import kotlinx.android.synthetic.main.fragment_input_details.inputAmount
import kotlinx.android.synthetic.main.fragment_input_details.inputName
import kotlinx.android.synthetic.main.fragment_input_details.rememberCheckBox
import kotlinx.android.synthetic.main.fragment_input_details.submitButton

class InputDetailsFragment : Fragment() {
  private lateinit var listener: OnInputListener

  interface OnInputListener {
    fun onInput(
      name: String,
      amount: Int,
      remember: Boolean
    )
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_input_details, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    submitButton.setOnClickListener {
      listener.onInput(
          inputName.text.asString(),
          inputAmount.text.asInt(),
          rememberCheckBox.isChecked
      )
    }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnInputListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnInputListener")
    }
  }
}
