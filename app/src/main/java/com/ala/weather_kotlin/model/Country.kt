package com.ala.weather_kotlin.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    var name: String?,

    @SerializedName("capital")
    var capital: String?,

    @SerializedName("region")
    var region: String?,

    @SerializedName("latlng")
    var latlng: List<Double>?,

    @SerializedName("alpha2Code")
    var countryCode: String?,

    @SerializedName("population")
    var population: Long = 0
)