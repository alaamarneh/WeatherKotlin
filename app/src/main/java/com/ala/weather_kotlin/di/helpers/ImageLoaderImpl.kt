package com.ala.weather_kotlin.di.helpers

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageLoaderImpl @Inject
constructor(private val context: Context) : ImageLoader {

    override fun loadIntoImage(imageView: ImageView, url: String) {
        Glide.with(context)
            .load(url)
            .into(imageView)
    }
}
