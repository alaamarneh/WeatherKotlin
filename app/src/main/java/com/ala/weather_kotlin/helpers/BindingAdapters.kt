package com.ala.weather_kotlin.helpers

import androidx.databinding.BindingAdapter
import android.widget.ImageView

object BindingAdapters {

    @BindingAdapter("android:src")
    @JvmStatic
    fun setImageViewResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}
