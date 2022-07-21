package com.example.accuweather.data.remote

import com.example.accuweather.data.model.FiveDayModel
import com.example.accuweather.data.model.LocationModelItem
import com.example.accuweather.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceAPI {

    @GET(Constants.LOCATION_ENDPOINT)
    suspend fun getCityLocation(
        @Query("q") q: String,
        @Query("apikey") apiKey: String = Constants.API_KEY
    ): Response<List<LocationModelItem>>

    @GET(Constants.FIVE_DAY_ENDPOINT)
    suspend fun getFiveDayForecast(
        @Path("location key") locationKey: String,
        @Query("apikey") apiKey: String = Constants.API_KEY
    ): Response<FiveDayModel>
}