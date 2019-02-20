package com.ala.weather_kotlin.binding

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.ala.weather_kotlin.utils.ImageUtils
import com.bumptech.glide.Glide

object BindingAdapters {

    @BindingAdapter("android:src")
    @JvmStatic
    fun setImageViewResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }

    @BindingAdapter("android:flag")
    @JvmStatic
    fun setImageViewUrl(imageView: ImageView, flag: String){
        Glide.with(imageView.context)
            .load(ImageUtils.prepareImageUrl(flag))
            .into(imageView)
    }
}
