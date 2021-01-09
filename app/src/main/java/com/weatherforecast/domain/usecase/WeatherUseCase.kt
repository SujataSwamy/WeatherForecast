package com.weatherforecast.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.weatherforecast.data.repository.WeatherRepository
import com.weatherforecast.domain.model.UIState

class WeatherUseCase(val weatherRepository: WeatherRepository) {
    suspend fun getWeatherData(
        placeName: String,
        weatherLiveData: MutableLiveData<UIState>
    ) {
        val weatherInfo = weatherRepository.getWeatherInfo(placeName)
        if(weatherInfo?.totalResults != null){
//            weatherLiveData.value = UIState.hasData
//            weatherLiveData.value = weatherInfo
        }else{
//            weatherLiveData.value = UIState.noData
        }
    }
}