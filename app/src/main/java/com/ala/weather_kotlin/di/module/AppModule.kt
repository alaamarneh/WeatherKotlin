package com.ala.weather_kotlin.di.module

import android.app.Application
import android.content.Context
import com.ala.weather_kotlin.di.helpers.ImageLoader
import com.ala.weather_kotlin.di.helpers.ImageLoaderImpl
import com.ala.weather_kotlin.di.repo.DataRepo
import com.ala.weather_kotlin.di.repo.DataRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideRepo(dataRepoImpl: DataRepoImpl): DataRepo {
        return dataRepoImpl
    }

    @Provides
    @Singleton
    fun provideImageLoader(imageLoader: ImageLoaderImpl): ImageLoader {
        return imageLoader
    }
}