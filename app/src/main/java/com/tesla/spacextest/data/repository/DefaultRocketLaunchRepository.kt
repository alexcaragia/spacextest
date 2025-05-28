package com.tesla.spacextest.data.repository

import com.tesla.spacextest.common.ErrorMessages
import com.tesla.spacextest.data.mappers.mapList
import com.tesla.spacextest.data.remote.RocketLaunchApi
import com.tesla.spacextest.domain.repository.RocketLaunchRepository
import com.tesla.spacextest.domain.rocket.RocketLaunchDisplayData
import com.tesla.spacextest.domain.util.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultRocketLaunchRepository(
    private val ioDispatcher: CoroutineDispatcher,
    private val rocketLaunchApi: RocketLaunchApi
): RocketLaunchRepository {
    override suspend fun getRocketLaunchData(): Response<List<RocketLaunchDisplayData>> {
        return withContext(ioDispatcher) {
            try {
                val result = rocketLaunchApi.getRocketLaunchList()
                Response.Success(data = result.mapList())
            } catch (exception: Exception) {
                // TODO: Catch network exceptions and populate the Response.Error object
                Response.Error(message = exception.message ?: ErrorMessages.UNKNOWN_ERROR.message)
            }
        }
    }
}