package com.ala.weather_kotlin.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class WeatherMain() : Parcelable{
    @SerializedName("temp_min")
    var tempMin: Double = 0.toDouble()

    @SerializedName("temp_max")
    var tempMax: Double = 0.toDouble()

    @SerializedName("pressure")
    var pressure: Double = 0.toDouble()

    @SerializedName("humidity")
    var humidity: Int = 0

    constructor(parcel: Parcel) : this() {
        tempMin = parcel.readDouble()
        tempMax = parcel.readDouble()
        pressure = parcel.readDouble()
        humidity = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(tempMin)
        parcel.writeDouble(tempMax)
        parcel.writeDouble(pressure)
        parcel.writeInt(humidity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherMain> {
        override fun createFromParcel(parcel: Parcel): WeatherMain {
            return WeatherMain(parcel)
        }

        override fun newArray(size: Int): Array<WeatherMain?> {
            return arrayOfNulls(size)
        }
    }
}