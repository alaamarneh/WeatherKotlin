package com.ala.weather_kotlin.utils

import android.text.format.DateUtils

fun Long.secondsToMillis(): Long = this * 1000


fun Long.isToday(): Boolean =
    DateUtils.isToday(this)


fun Long.isTomorrow(): Boolean =
    DateUtils.isToday(this - DateUtils.DAY_IN_MILLIS)
