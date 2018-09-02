package com.example.kotlinnavigationsample.main

/**
 * Created by vishnu on 30/8/18.
 */
data class Example(
  var type: Int,
  var title: String
) {
  companion object {
    const val BASIC_NAV = 0
    const val BOTTOM_NAV = 1
    const val DRAWER_NAV = 2
    const val DEEP_NAV = 3
    const val SAFE_ARGS = 4
    const val CONDITIONAL_NAV = 5

    fun getItems(): List<Example> {
      return listOf(
          Example(
              BASIC_NAV,
              "Basic Navigation"
          ),
          Example(
              BOTTOM_NAV,
              "Bottom Navigation"
          ),
          Example(
              DRAWER_NAV,
              "Drawer Navigation"
          ),
          Example(
              DEEP_NAV, "Deep Navigation"
          ),
          Example(
              SAFE_ARGS, "Safe Args Navigation"
          ),
          Example(
              CONDITIONAL_NAV, "Conditional Navigation"
          )
      )
    }
  }
}