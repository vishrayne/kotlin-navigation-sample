package com.example.kotlinnavigationsample.conditional

/**
 * Created by vishnu on 11/9/18.
 */
open class Event<out T>(private val content: T) {
  var hasBeenhandled = false
    private set

  fun getContentIfNotHandled(): T? {
    return if (hasBeenhandled) {
      null
    } else {
      hasBeenhandled = true
      content
    }
  }

  /**
   * Returns the content, even if it's already been handled.
   */
  fun peekContent(): T = content
}