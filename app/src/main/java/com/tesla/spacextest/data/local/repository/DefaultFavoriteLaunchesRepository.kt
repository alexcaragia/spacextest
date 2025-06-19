package com.tesla.spacextest.data.local.repository

import com.tesla.spacextest.data.local.database.dao.FavoriteLaunchDetailsDao
import com.tesla.spacextest.data.local.database.dao.FavoritesLaunchDao
import com.tesla.spacextest.data.local.database.entities.FavoriteLaunchEntity
import com.tesla.spacextest.domain.repository.FavoriteLaunchesRepository

class DefaultFavoriteLaunchesRepository(
    private val favoritesLaunchDao: FavoritesLaunchDao,
    private val favoriteLaunchDetailsDao: FavoriteLaunchDetailsDao
): FavoriteLaunchesRepository {
    override suspend fun addFavorite(launchEntity: FavoriteLaunchEntity) {

    }

    override suspend fun removeFavorite(launchEntity: FavoriteLaunchEntity) {

    }

    override suspend fun isFavorite(id: Int): Boolean = favoritesLaunchDao.isFavorite(id)

    override suspend fun getAllFavorites(): List<FavoriteLaunchEntity> {
        
    }
}