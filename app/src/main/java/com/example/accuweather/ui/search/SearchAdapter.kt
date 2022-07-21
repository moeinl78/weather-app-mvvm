package com.example.accuweather.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.accuweather.data.model.LocationDB
import com.example.accuweather.data.model.LocationModelItem
import com.example.accuweather.databinding.ItemRecyclerViewSearchBinding
import com.example.accuweather.utils.LocationModelDiffCallback

class SearchAdapter(private val searchEvents: SearchEvents): ListAdapter<LocationModelItem, SearchAdapter.ViewHolder>(LocationModelDiffCallback()) {

    class ViewHolder private constructor(private val binding: ItemRecyclerViewSearchBinding) :RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRecyclerViewSearchBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: LocationModelItem, searchEvents: SearchEvents) {
            binding.searchCurrentCity.text = item.englishName
            binding.searchAddButton.setOnClickListener {
                searchEvents.onClickListener(
                    LocationDB(
                        key = item.key,
                        localizedName = item.localizedName,
                        englishName = item.englishName
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, searchEvents)
    }

    interface SearchEvents {
        fun onClickListener(locationDB: LocationDB)
    }
}