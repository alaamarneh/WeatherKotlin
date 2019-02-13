package com.ala.weather_kotlin.helpers

import android.widget.ImageView

interface ImageLoader {
    fun loadIntoImage(imageView: ImageView, url: String)
}
