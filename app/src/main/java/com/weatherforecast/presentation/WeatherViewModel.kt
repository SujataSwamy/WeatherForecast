package com.weatherforecast.presentation

import androidx.annotation.UiThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weatherforecast.domain.usecase.WeatherUseCase
import androidx.lifecycle.viewModelScope
import com.weatherforecast.domain.model.UIState
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherUseCase: WeatherUseCase) : ViewModel() {
    val weatherLiveData: MutableLiveData<UIState>
    init {
        weatherLiveData= MutableLiveData()
    }
    @UiThread
     fun getWeatherData(placeName: String) {
        weatherLiveData.value = UIState.Loading
        viewModelScope.launch {
            weatherUseCase.getWeatherData(placeName,weatherLiveData)
        }
    }
}