package com.example.accuweather.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.accuweather.data.model.LocationModelItem

class LocationModelDiffCallback: DiffUtil.ItemCallback<LocationModelItem>() {
    override fun areItemsTheSame(oldItem: LocationModelItem, newItem: LocationModelItem): Boolean {
        return oldItem.key == newItem.key
    }

    override fun areContentsTheSame(oldItem: LocationModelItem, newItem: LocationModelItem): Boolean {
        return oldItem == newItem
    }
}