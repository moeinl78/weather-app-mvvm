package com.example.accuweather.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class LocationDB(
    @PrimaryKey(autoGenerate = false)
    val key: String,
    val localizedName: String,
    val englishName: String
)