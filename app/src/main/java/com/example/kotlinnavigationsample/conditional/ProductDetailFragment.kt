package com.example.kotlinnavigationsample.conditional

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinnavigationsample.R
import com.example.kotlinnavigationsample.conditional.UserState.Cancelled
import com.example.kotlinnavigationsample.conditional.UserState.Guest
import com.example.kotlinnavigationsample.conditional.UserState.LoginSuccess
import kotlinx.android.synthetic.main.fragment_product_detail.addToCartButton
import kotlinx.android.synthetic.main.fragment_product_detail.productDetailAmount
import kotlinx.android.synthetic.main.fragment_product_detail.productDetailDesc
import kotlinx.android.synthetic.main.fragment_product_detail.productDetailID
import kotlinx.android.synthetic.main.fragment_product_detail.productDetailImage
import kotlinx.android.synthetic.main.fragment_product_detail.productDetailTitle

class ProductDetailFragment : Fragment() {
  private lateinit var listener: OnProductDetailInteractionListener
  private val productViewModel: ProductViewModel by lazy {
    ViewModelProviders.of(requireActivity())
        .get(ProductViewModel::class.java)
  }

  interface OnProductDetailInteractionListener {
    fun onProductDetailInteraction(
      productID: Int,
      count: Int
    )

    fun requestLogin(actionID: Int)

    fun popStack()
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_product_detail, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    productViewModel.eventState.observe(this, Observer {
      it.getContentIfNotHandled()
          ?.let(::handleState)
    })
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnProductDetailInteractionListener) {
      listener = context
    } else {
      throw RuntimeException(
          context.toString() + " must implement OnProductDetailInteractionListener"
      )
    }
  }

  private fun handleState(state: UserState) = when (state) {
    is Guest -> listener.requestLogin(R.id.action_productDetailFragment_to_loginFragment)
    is Cancelled -> listener.popStack()
    is LoginSuccess -> showProductDetails(arguments!!, state.name)
  }

  private fun showProductDetails(
    args: Bundle,
    userName: String
  ) {
    val product: Product = ProductDetailFragmentArgs.fromBundle(args)
        .run {
          productViewModel.findProductById(productId)
        }

    productDetailImage.setImageResource(product.imageRes)
    productDetailTitle.text = product.name
    productDetailDesc.text = product.description
    productDetailAmount.text = product.amountAsCurrency
    productDetailID.text = product.wareHouseID

    addToCartButton.setOnClickListener {
      listener.onProductDetailInteraction(product.id, 1)
    }
  }
}
