package com.ala.weather_kotlin.net

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory{
    companion object {
        fun createCountriesApiHelper(): ApiHelper{
             val retrofit = Retrofit.Builder()
                .baseUrl("https://restcountries.eu")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

            return retrofit.create(ApiHelper::class.java)
        }
        fun createWeatherApiHelper(): ApiHelper{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://restcountries.eu")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

            return retrofit.create(ApiHelper::class.java)
        }
    }
}