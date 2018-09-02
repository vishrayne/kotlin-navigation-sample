package com.example.kotlinnavigationsample.safeargs

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kotlinnavigationsample.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_confirm_input.confirmAmountText
import kotlinx.android.synthetic.main.fragment_confirm_input.confirmNameText
import kotlinx.android.synthetic.main.fragment_confirm_input.confirmRememberText
import kotlinx.android.synthetic.main.fragment_confirm_input.doneButton

class ConfirmInputFragment : Fragment() {
  private lateinit var listener: OnConfirmInputListener

  interface OnConfirmInputListener {
    fun onConfirmInput(boolean: Boolean)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_confirm_input, container, false)
  }

  @SuppressLint("SetTextI18n")
  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    with(ConfirmInputFragmentArgs.fromBundle(arguments)) {
      confirmNameText.text = name
      confirmAmountText.text = "\u20B9 $amount"

      with(if (rememberChoice) "will" else "won't") {
        confirmRememberText.text = "I $this remember this choice!"
      }
    }

    doneButton.setOnClickListener {
      Snackbar.make(it, "Demo complete!", Snackbar.LENGTH_SHORT)
          .show()
      listener.onConfirmInput(true)
    }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnConfirmInputListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnConfirmInputListener")
    }
  }
}
