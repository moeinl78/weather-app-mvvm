package com.example.accuweather.di

import com.example.accuweather.data.remote.ServiceAPI
import com.example.accuweather.repository.MainRepository
import com.example.accuweather.utils.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(ServiceAPI::class.java)
    }

    factory {
        MainRepository(get())
    }
}