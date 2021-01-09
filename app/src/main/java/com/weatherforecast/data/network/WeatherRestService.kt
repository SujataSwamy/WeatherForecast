package com.weatherforecast.data.network

import com.weatherforecast.domain.model.Pojo
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
    // http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=c9d1ca843e054a96b18a3851d805d2aa
    @GET("top-headlines?apiKey=c9d1ca843e054a96b18a3851d805d2aa")
    suspend fun getWeatherInfo(
        @Query("country") cityName: String?,
        @Query("category") days: String?
    ): Pojo?

}
