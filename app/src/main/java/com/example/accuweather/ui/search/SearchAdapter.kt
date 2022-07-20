package com.example.accuweather.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.accuweather.data.model.LocationModel
import com.example.accuweather.databinding.ItemRecyclerViewSearchBinding
import com.example.accuweather.utils.LocationModelDiffCallback

class SearchAdapter: ListAdapter<LocationModel, SearchAdapter.ViewHolder>(LocationModelDiffCallback()) {

    class ViewHolder private constructor(private val binding: ItemRecyclerViewSearchBinding) :RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRecyclerViewSearchBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: LocationModel) {
            binding.searchCurrentCity.text = item[adapterPosition].englishName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}