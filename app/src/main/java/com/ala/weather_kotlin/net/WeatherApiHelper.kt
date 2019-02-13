package com.ala.weather_kotlin.net

import com.ala.weather_kotlin.net.response.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApiHelper {
    @GET("forecast")
    fun getWeather(@Query("lat") lat: Double, @Query("lon") lng: Double, @Query("appid") appId: String): Single<WeatherResponse>
}
