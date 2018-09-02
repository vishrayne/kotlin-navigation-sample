package com.example.kotlinnavigationsample.conditional

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.example.kotlinnavigationsample.R
import kotlinx.android.synthetic.main.fragment_product_list.productRecyclerView

class ProductListFragment : Fragment() {
  private lateinit var listener: OnProductInteractionListener

  interface OnProductInteractionListener {
    fun onProductInteraction(productID: Int)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_product_list, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    productRecyclerView.apply {
      layoutManager = GridLayoutManager(context, 2)
      adapter = ProductAdapter(Product.getDefaultList()) {
        listener.onProductInteraction(it.id)
      }
    }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnProductInteractionListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnProductInteractionListener")
    }
  }
}
