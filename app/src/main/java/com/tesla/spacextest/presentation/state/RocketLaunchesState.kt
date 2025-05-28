package com.tesla.spacextest.presentation.state

import androidx.annotation.StringRes
import com.tesla.spacextest.domain.rocket.RocketLaunchDisplayData

sealed class RocketLaunchesState {
    data object Loading : RocketLaunchesState()
    data class CurrentRocketLaunches(val data: List<RocketLaunchDisplayData>) : RocketLaunchesState()
    data class Error(@StringRes val errorMessage: Int) : RocketLaunchesState()
}