package com.example.kotlinnavigationsample.main

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnavigationsample.R
import com.example.kotlinnavigationsample.util.inflate
import kotlinx.android.synthetic.main.item_list_example.view.exampleName

/**
 * Created by vishnu on 30/8/18.
 */
class ExampleAdapter(
  private val exampleList: List<Example>,
  private val listener: (Example) -> Unit
) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ExampleViewHolder = ExampleViewHolder(parent.inflate(R.layout.item_list_example))

  override fun onBindViewHolder(
    holder: ExampleViewHolder,
    position: Int
  ) = holder.bind(exampleList[position], listener)

  override fun getItemCount() = exampleList.size

  class ExampleViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleView: TextView = itemView.exampleName

    fun bind(
      example: Example,
      listener: (Example) -> Unit
    ) = with(itemView) {
      titleView.text = example.title
      setOnClickListener {
        listener(example)
      }
    }
  }
}