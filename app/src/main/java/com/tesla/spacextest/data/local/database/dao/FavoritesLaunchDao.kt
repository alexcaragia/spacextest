package com.tesla.spacextest.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.tesla.spacextest.data.local.database.entities.DetailedFavoriteLaunch
import com.tesla.spacextest.data.local.database.entities.FavoriteLaunchEntity

@Dao
interface FavoritesLaunchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(launchEntity: FavoriteLaunchEntity)

    @Delete
    suspend fun removeFavorite(launchEntity: FavoriteLaunchEntity)

    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<FavoriteLaunchEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE launchId = :id)")
    suspend fun isFavorite(id: Int): Boolean

    @Transaction
    @Query("SELECT * FROM favorites")
    suspend fun getFavoriteLaunchesWithDetails(): List<DetailedFavoriteLaunch>
}