package com.ala.weather_kotlin.di.helpers

import android.widget.ImageView

interface ImageLoader {
    fun loadIntoImage(imageView: ImageView, url: String)
}
