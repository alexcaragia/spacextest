package com.tesla.spacextest.domain.repository

import com.tesla.spacextest.data.local.database.entities.FavoriteLaunchEntity

interface FavoriteLaunchesRepository {
    suspend fun addFavorite(launchEntity: FavoriteLaunchEntity)
    suspend fun removeFavorite(launchEntity: FavoriteLaunchEntity)
    suspend fun isFavorite(id: Int): Boolean
    suspend fun getAllFavorites(): List<FavoriteLaunchEntity>
}