package com.example.kotlinnavigationsample.conditional

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnavigationsample.R
import com.example.kotlinnavigationsample.util.inflate
import kotlinx.android.synthetic.main.item_list_product.view.productImage
import kotlinx.android.synthetic.main.item_list_product.view.productName
import kotlinx.android.synthetic.main.item_list_product.view.productPrice

class ProductAdapter(
  private val products: List<Product>,
  private val listener: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ProductViewHolder = ProductViewHolder(parent.inflate(R.layout.item_list_product))

  override fun onBindViewHolder(
    holder: ProductViewHolder,
    position: Int
  ) {
    holder.bind(products[position], listener)
  }

  override fun getItemCount(): Int = products.size

  class ProductViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val productNameTextView: TextView = itemView.productName
    private val productAmountTextView: TextView = itemView.productPrice
    private val productImageView: ImageView = itemView.productImage

    @SuppressLint("SetTextI18n")
    fun bind(
      product: Product,
      listener: (Product) -> Unit
    ) = with(itemView) {
      productImageView.setImageResource(product.imageRes)
      productNameTextView.text = product.name
      productAmountTextView.text = product.amountAsCurrency

      setOnClickListener {
        listener(product)
      }
    }
  }
}