package com.weatherforecast.domain.model

sealed class UIState {
    object Loading : UIState()
    object hasData : UIState()
    object noData : UIState()
    data class LocationResponse(
        var request: Request?,
        var current: Current?,
        var location: Location?
    ) : UIState()
}
