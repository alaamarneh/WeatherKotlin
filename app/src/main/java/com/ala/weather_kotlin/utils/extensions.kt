package com.ala.weather_kotlin.utils

import android.text.format.DateUtils
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun Long.secondsToMillis(): Long = this * 1000


fun Long.isToday(): Boolean =
    DateUtils.isToday(this)


fun Long.isTomorrow(): Boolean =
    DateUtils.isToday(this - DateUtils.DAY_IN_MILLIS)

fun <T> Single<T>.runOnMain(): Single<T> = subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

