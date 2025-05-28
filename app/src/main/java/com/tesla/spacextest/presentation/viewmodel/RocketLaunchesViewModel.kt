package com.tesla.spacextest.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tesla.spacextest.domain.repository.RocketLaunchRepository
import com.tesla.spacextest.presentation.state.RocketLaunchesState
import kotlinx.coroutines.launch

class RocketLaunchesViewModel(
    private val repository: RocketLaunchRepository
) : ViewModel() {
    private val rocketLaunchesStateData: MutableLiveData<RocketLaunchesState> = MutableLiveData()
    val rocketLaunchesState: LiveData<RocketLaunchesState> = rocketLaunchesStateData

    fun loadRocketLaunches() {
        viewModelScope.launch {
            rocketLaunchesStateData.postValue(RocketLaunchesState.Loading)
            rocketLaunchesStateData.postValue(repository.getRocketLaunchData().data?.let {
                RocketLaunchesState.CurrentRocketLaunches(data = it)
            })
        }
    }
}