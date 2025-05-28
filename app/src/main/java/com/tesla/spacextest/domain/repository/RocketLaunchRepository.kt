package com.tesla.spacextest.domain.repository

import com.tesla.spacextest.domain.rocket.RocketLaunchDisplayData
import com.tesla.spacextest.domain.util.Response

interface RocketLaunchRepository {
    suspend fun getRocketLaunchData() : Response<List<RocketLaunchDisplayData>>
}