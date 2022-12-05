package com.example.stories

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.models.Story

import com.example.stories.databinding.FragmentItemBinding

class StoryRecyclerViewAdapter(
    private var values: List<Story>
) : RecyclerView.Adapter<StoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.title
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber

        override fun toString(): String {
            return super.toString()
        }
    }

    fun updateAdapter(list: List<Story>){
        values = list
        notifyDataSetChanged()
    }
}