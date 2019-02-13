package com.ala.weather_kotlin.di.component

import com.ala.weather_kotlin.app.App
import com.ala.weather_kotlin.di.builder.BuilderModule
import com.ala.weather_kotlin.di.module.AppModule
import com.ala.weather_kotlin.di.module.NetworkModule
import com.ala.weather_kotlin.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, NetworkModule::class, BuilderModule::class, AndroidInjectionModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {
    fun inject(app: App)
}