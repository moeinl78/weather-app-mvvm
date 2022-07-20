package com.example.accuweather.repository

import com.example.accuweather.data.remote.ServiceAPI

class MainRepository(private val serviceAPI: ServiceAPI) {

    suspend fun getCityLocation(cityName: String) =
        serviceAPI.getCityLocation(cityName)

    suspend fun getFiveDayForecast(locationKey: String) =
        serviceAPI.getFiveDayForecast(locationKey)
}