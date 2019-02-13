package com.ala.weather_kotlin.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Weather() : Parcelable{
    @SerializedName("dt")
    var date: Long = 0

    @SerializedName("main")
    var weatherMain: WeatherMain? = null

    constructor(parcel: Parcel) : this() {
        date = parcel.readLong()
        weatherMain = parcel.readParcelable(WeatherMain::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(date)
        parcel.writeParcelable(weatherMain, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Weather> {
        override fun createFromParcel(parcel: Parcel): Weather {
            return Weather(parcel)
        }

        override fun newArray(size: Int): Array<Weather?> {
            return arrayOfNulls(size)
        }
    }
}