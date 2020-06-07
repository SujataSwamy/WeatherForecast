package com.weatherforecast.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders.of
import com.weatherforecast.R
import com.weatherforecast.di.WeatherViewModelFactory
import com.weatherforecast.domain.model.UIState
import kotlinx.android.synthetic.main.weather_activity.*
import com.weatherforecast.domain.model.UIState.LocationResponse as TemperatureResponse1

class WeatherActivity : AppCompatActivity() {

    private lateinit var weatherViewModel: WeatherViewModel
    private var factory: WeatherViewModelFactory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_activity)
        // Initialize HomeViewModel
        factory = WeatherViewModelFactory.getInstance(application)
        weatherViewModel = of(this, factory).get(WeatherViewModel::class.java)

        weatherViewModel.weatherLiveData.observe(this, observer)
        button.setOnClickListener(clickListener)
    }

    private val observer = object : Observer<UIState> {
        override fun onChanged(t: UIState) {
            updateUI(t)
        }
    }

    private val clickListener = object : View.OnClickListener {
        override fun onClick(p0: View?) {
            weatherViewModel.getWeatherData(placename.text.toString())
        }
    }

    private fun updateUI(temperatureResponse: UIState) {
        when (temperatureResponse) {
            is UIState.Loading -> {
                loading.visibility = View.VISIBLE
                loading.text = resources.getString(R.string.loading)
            }

            is UIState.noData -> {
                loading.visibility = View.VISIBLE
                loading.text = resources.getString(R.string.no_data)
                country.visibility = View.INVISIBLE
                name.visibility = View.INVISIBLE
                localtime.visibility = View.INVISIBLE
                region.visibility = View.INVISIBLE
            }

            is UIState.hasData -> {
                loading.visibility = View.INVISIBLE
                country.visibility = View.VISIBLE
                name.visibility = View.VISIBLE
                localtime.visibility = View.VISIBLE
                region.visibility = View.VISIBLE
            }

            is TemperatureResponse1 -> {
                country.setText("Country:" + temperatureResponse?.location?.country)
                name.setText("Name:" + temperatureResponse?.location?.name)
                localtime.setText("Local Time:" + temperatureResponse?.location?.localtime)
                region.setText("Local Time:" + temperatureResponse?.location?.region)
            }
        }
    }
}


