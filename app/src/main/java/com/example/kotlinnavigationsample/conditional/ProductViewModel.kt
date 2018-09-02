package com.example.kotlinnavigationsample.conditional

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
  private val _products: MutableLiveData<List<Product>> = MutableLiveData()
  // faster lookup, compared to list
  private val _productMap by lazy {
    _products.value?.map { it.id to it }
        ?.toMap()
  }

  val products: LiveData<List<Product>>
    get() {
      if (_products.value == null) {
        Log.d("ProductViewModel", "Initializing products...")
        _products.value = Product.getDefaultList()
      }

      return _products
    }

  fun findProductById(id: Int): Product {
    return _productMap?.get(id) ?: Product.invalid
  }
}