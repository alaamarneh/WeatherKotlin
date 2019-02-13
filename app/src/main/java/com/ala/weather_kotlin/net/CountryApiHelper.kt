package com.ala.weather_kotlin.net

import com.ala.weather_kotlin.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApiHelper {

    @GET("rest/v1/all")
    fun getAllCountries () : Single<List<Country>>

}
