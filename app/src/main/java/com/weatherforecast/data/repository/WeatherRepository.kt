package com.weatherforecast.data.repository

import com.weatherforecast.data.datasource.WeatherRemoteDataSource
import com.weatherforecast.domain.model.Pojo
import com.weatherforecast.domain.model.UIState
import javax.inject.Singleton

@Singleton
class WeatherRepository(val weatherRemoteDataSource: WeatherRemoteDataSource) {

    suspend fun getWeatherInfo(placeName: String): Pojo? {
        return weatherRemoteDataSource.getWeatherInfo(placeName)
    }

    companion object {
        private var INSTANCE: WeatherRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         *
         *
         * @return the [WeatherRepository] instance
         */
        fun getInstance(
            salesDataSource: WeatherRemoteDataSource
        ): WeatherRepository? {
            if (INSTANCE == null) {
                synchronized(WeatherRepository::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = WeatherRepository(salesDataSource)
                    }
                }
            }
            return INSTANCE
        }
    }
}
