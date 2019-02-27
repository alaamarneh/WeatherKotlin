package com.ala.weather_kotlin.utils

import android.text.format.DateUtils
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun Long.secondsToMillis(): Long = this * 1000


fun Long.isToday(): Boolean =
    DateUtils.isToday(this)


fun Long.isTomorrow(): Boolean =
    DateUtils.isToday(this - DateUtils.DAY_IN_MILLIS)

fun <T> Single<T>.runOnMain(): Single<T> = subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())


