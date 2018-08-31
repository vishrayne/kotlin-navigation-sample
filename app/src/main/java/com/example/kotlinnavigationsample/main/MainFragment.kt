package com.example.kotlinnavigationsample.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinnavigationsample.R
import kotlinx.android.synthetic.main.fragment_main_list.exampleRecyclerView

class MainFragment : Fragment() {
  private lateinit var listener: OnItemInteractionListener

  interface OnItemInteractionListener {
    fun onItemInteraction(itemID: Int)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_main_list, container, false)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    exampleRecyclerView.apply {
      setHasFixedSize(true)
      addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
      layoutManager = LinearLayoutManager(context)
      adapter = ExampleAdapter(Example.getItems()) {
        listener.onItemInteraction(it.type)
      }
    }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnItemInteractionListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnItemInteractionListener")
    }
  }

}
