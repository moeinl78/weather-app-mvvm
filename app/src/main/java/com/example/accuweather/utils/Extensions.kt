package com.example.accuweather.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.accuweather.data.model.LocationModel

class LocationModelDiffCallback: DiffUtil.ItemCallback<LocationModel>() {
    override fun areItemsTheSame(oldItem: LocationModel, newItem: LocationModel): Boolean {
        return oldItem[0].key == newItem[0].key
    }

    override fun areContentsTheSame(oldItem: LocationModel, newItem: LocationModel): Boolean {
        return oldItem == newItem
    }
}