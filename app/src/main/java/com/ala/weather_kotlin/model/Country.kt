package com.ala.weather_kotlin.model

import com.google.gson.annotations.SerializedName

class Country{
    @SerializedName("name")
    var name: String? = null

    @SerializedName("capital")
    var capital: String? = null

    @SerializedName("region")
    var region: String? = null

    @SerializedName("latlng")
    var latlng: List<Double>? = null

    @SerializedName("alpha2Code")
    var countryCode: String? = null

    @SerializedName("population")
    var population: Long = 0
}