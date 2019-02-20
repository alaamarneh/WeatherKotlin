package com.ala.weather_kotlin.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun getDayName(timeInSeconds: Long): String {
        val dateFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        return dateFormat.format(Date(timeInSeconds * 1000))
    }
}