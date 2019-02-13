package com.ala.weather_kotlin.di.module

import com.ala.weather_kotlin.net.CountryApiHelper
import com.ala.weather_kotlin.net.WeatherApiHelper
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule{

    @Provides
    @Singleton
    fun provideCountriesApiHelper() : CountryApiHelper{
        val retrofit = Retrofit.Builder().baseUrl("https://restcountries.eu")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(CountryApiHelper::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherApiHelper() : WeatherApiHelper{
        val retrofit = Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(WeatherApiHelper::class.java)
    }
}