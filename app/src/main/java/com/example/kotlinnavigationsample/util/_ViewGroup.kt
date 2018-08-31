package com.example.kotlinnavigationsample.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by vishnu on 30/8/18.
 */

fun ViewGroup.inflate(layoutRes: Int): View =
  LayoutInflater.from(context).inflate(layoutRes, this, false)
