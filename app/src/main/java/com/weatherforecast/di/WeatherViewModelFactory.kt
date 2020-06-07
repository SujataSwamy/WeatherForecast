package com.weatherforecast.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weatherforecast.data.repository.WeatherRepository
import com.weatherforecast.domain.usecase.WeatherUseCase
import com.weatherforecast.presentation.WeatherViewModel

/**
 * This creator is to showcase how to inject dependencies into ViewModels.
 */
class WeatherViewModelFactory private constructor(private val weatherRepository: WeatherRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(
                WeatherUseCase(
                    weatherRepository
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var INSTANCE: WeatherViewModelFactory? = null
        private var application_: Application? = null

        fun getInstance(application: Application): WeatherViewModelFactory? {
            application_ = application
            if (INSTANCE == null) {
                synchronized(WeatherViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Injection.provideWeatherRepository(application.applicationContext)
                                ?.let {
                                    WeatherViewModelFactory(
                                        it
                                    )
                                }
                    }
                }
            }
            return INSTANCE
        }
    }
}
