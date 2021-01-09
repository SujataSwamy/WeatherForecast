package com.weatherforecast.domain.model

data class Current(
    var weather_descriptions: Array<String>,
    var observation_time: String?,
    var wind_degree: String?,
    var visibility: String,
    var weather_icons: Array<String>,
    var feelslike: String?,
    var is_day: String?,
    var wind_dir: String?,
    var pressure: String?,
    var cloudcover: String?,
    var precip: String?,
    var uv_index: String?,
    var temperature: String?,
    var humidity: String?,
    var wind_speed: String?,
    var weather_code: String?
)
