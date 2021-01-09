package com.weatherforecast.di

import android.content.Context
import com.weatherforecast.data.datasource.WeatherRemoteDataSource
import com.weatherforecast.data.repository.WeatherRepository

object Injection {

    fun provideWeatherRepository(context: Context): WeatherRepository? {
        checkNotNull(context)
        return WeatherRepository.getInstance(WeatherRemoteDataSource.instance)
    }
}
