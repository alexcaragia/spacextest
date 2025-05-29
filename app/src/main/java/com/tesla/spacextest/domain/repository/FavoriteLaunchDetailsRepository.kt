package com.tesla.spacextest.domain.repository

import com.tesla.spacextest.data.local.database.FavoriteLaunchDetailsEntity

interface FavoriteLaunchDetailsRepository {
    suspend fun insertLaunchDetails(launchDetailsEntity: FavoriteLaunchDetailsEntity)
    suspend fun deleteByLaunchId(launchId: Int)
}