package com.example.kotlinnavigationsample.util

import android.text.Editable

fun Editable?.asString() = this?.toString() ?: ""

fun Editable?.asInt() = this?.toString()?.let {
  try {
    it.toInt()
  } catch (e: NumberFormatException) {
    0
  }
} ?: 0