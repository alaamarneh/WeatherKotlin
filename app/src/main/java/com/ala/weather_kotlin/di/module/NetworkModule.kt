package com.ala.weather_kotlin.di.module

import com.ala.weather_kotlin.net.CountryApiHelper
import com.ala.weather_kotlin.net.WeatherApiHelper
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor


@Module
class NetworkModule {

    companion object {
        const val COUNTRIES_BASE_URL = "https://restcountries.eu/"
        const val WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/"
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideCountriesApiHelper(httpClient: OkHttpClient): CountryApiHelper {

        val retrofit = Retrofit.Builder().baseUrl(COUNTRIES_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
        return retrofit.create(CountryApiHelper::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherApiHelper(okHttpClient: OkHttpClient): WeatherApiHelper {
        val retrofit = Retrofit.Builder().baseUrl(WEATHER_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(WeatherApiHelper::class.java)
    }
}