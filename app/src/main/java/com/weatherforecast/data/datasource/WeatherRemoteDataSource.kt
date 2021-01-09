package com.weatherforecast.data.datasource

import androidx.annotation.WorkerThread
import com.weatherforecast.data.network.ApiClient
import com.weatherforecast.data.network.WeatherRestService
import com.weatherforecast.domain.model.Pojo

/*
Class that makes a remorte data call
 */
class WeatherRemoteDataSource() {
    companion object {
        private var salesDataSource: WeatherRemoteDataSource? = null
        val instance: WeatherRemoteDataSource
            get() {
                if (salesDataSource == null) {
                    salesDataSource = WeatherRemoteDataSource()
                }
                return salesDataSource as WeatherRemoteDataSource
            }
    }

    @WorkerThread
    suspend fun getWeatherInfo(placeName: String): Pojo? {
        val apiClient = ApiClient.client?.create(WeatherRestService::class.java)
        return apiClient?.getWeatherInfo("us", "business")
    }
}
