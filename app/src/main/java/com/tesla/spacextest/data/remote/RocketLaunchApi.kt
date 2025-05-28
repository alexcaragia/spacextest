package com.tesla.spacextest.data.remote

import retrofit2.http.GET

interface RocketLaunchApi {
    @GET("launches")
    suspend fun getRocketLaunchList(): List<RocketLaunchInfoDto>
}