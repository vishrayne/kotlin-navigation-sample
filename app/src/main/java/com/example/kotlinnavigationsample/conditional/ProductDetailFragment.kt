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

    val product: Product = ProductDetailFragmentArgs.fromBundle(arguments)
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
}
