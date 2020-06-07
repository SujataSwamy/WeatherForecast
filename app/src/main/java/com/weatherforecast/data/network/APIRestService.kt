package com.weatherforecast.data.network

import com.weatherforecast.domain.model.UIState
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * This class is responsible for holding all APIs need to be invoked by the application.
 *
 * @author Sujata
 */
interface WeatherRestService {
    /**
     * Returns weather info response which will be observed by the callee.
     *
     * @param cityName name of the city to be searched
     * @param days     no. of days for forecast data
     * @return [<]
     */
    @GET("current?" +"access_key=40385628c384f9452987ffa7cd63e791")
    suspend fun getWeatherInfo(
        @Query("query") cityName: String?,
        @Query("forecast_days") days: String?
    ): UIState.LocationResponse?
}