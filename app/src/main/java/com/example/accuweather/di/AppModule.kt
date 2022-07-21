package com.example.accuweather.di

import androidx.room.Room
import com.example.accuweather.data.local.DataBase
import com.example.accuweather.data.local.LocationDAO
import com.example.accuweather.data.remote.ServiceAPI
import com.example.accuweather.repository.MainRepository
import com.example.accuweather.ui.main.MainViewModel
import com.example.accuweather.utils.Constants
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
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

    single {
        Room.databaseBuilder(
            androidApplication(),
            DataBase::class.java,
            "database"
        )
            .build()
    }

    single {
        get<DataBase>().getLocationDAO()
    }

    factory {
        MainRepository(get(), get())
    }

    viewModel {
        MainViewModel(get())
    }
}