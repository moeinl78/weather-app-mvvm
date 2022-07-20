package com.example.accuweather.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.accuweather.data.model.LocationModel
import com.example.accuweather.databinding.ItemRecyclerViewBinding
import com.example.accuweather.utils.LocationModelDiffCallback

class HomeAdapter: ListAdapter<LocationModel, HomeAdapter.ViewHolder>(LocationModelDiffCallback()) {

    class ViewHolder private constructor(private val binding: ItemRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRecyclerViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(location: LocationModel) {
            binding.homeCurrentCity.text = location[adapterPosition].englishName
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