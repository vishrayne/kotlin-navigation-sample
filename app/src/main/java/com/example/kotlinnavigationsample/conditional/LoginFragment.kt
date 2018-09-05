package com.example.kotlinnavigationsample.conditional

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinnavigationsample.R
import com.example.kotlinnavigationsample.util.asString
import kotlinx.android.synthetic.main.fragment_login.loginButton
import kotlinx.android.synthetic.main.fragment_login.password
import kotlinx.android.synthetic.main.fragment_login.passwordText
import kotlinx.android.synthetic.main.fragment_login.userName
import kotlinx.android.synthetic.main.fragment_login.userNameText

class LoginFragment : Fragment() {
  private lateinit var listener: OnLoginInteractionListener
  private val productViewModel: ProductViewModel by lazy {
    ViewModelProviders.of(requireActivity())
        .get(ProductViewModel::class.java)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_login, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    loginButton.setOnClickListener {
      when {
        userNameText.text.isNullOrEmpty() -> userName.error = "Invalid user"
        passwordText.text.isNullOrEmpty() -> password.error = "Invalid password"
        else -> {
          userNameText.text.asString()
              .apply {
                productViewModel.setUser(this)
                listener.onLoginInteraction(this)
              }
        }
      }
    }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnLoginInteractionListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnLoginInteractionListener")
    }
  }

  interface OnLoginInteractionListener {
    fun onLoginInteraction(userName: String)
  }

}
