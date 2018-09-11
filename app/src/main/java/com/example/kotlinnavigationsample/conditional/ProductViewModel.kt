package com.example.kotlinnavigationsample.conditional

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinnavigationsample.conditional.UserState.Guest

class ProductViewModel : ViewModel() {
  private val _products: MutableLiveData<List<Product>> = MutableLiveData()
  private val _userEventState: MutableLiveData<Event<UserState>> = MutableLiveData()

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

  val eventState: LiveData<Event<UserState>>
    get() {
      if (_userEventState.value == null) {
        _userEventState.value = Event(Guest)
      }

      return _userEventState
    }

  fun setUserState(state: UserState) {
    _userEventState.value = Event(state)
  }

  fun findProductById(id: Int): Product {
    return _productMap?.get(id) ?: Product.invalid
  }
}

sealed class UserState {
  object Guest : UserState()
  object Cancelled : UserState()
  data class LoginSuccess(val name: String) : UserState()
}