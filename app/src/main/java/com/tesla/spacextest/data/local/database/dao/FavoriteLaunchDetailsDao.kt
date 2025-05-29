package com.tesla.spacextest.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tesla.spacextest.data.local.database.FavoriteLaunchDetailsEntity

@Dao
interface FavoriteLaunchDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchDetails(launchDetailsEntity: FavoriteLaunchDetailsEntity)

    @Query("DELETE FROM launch_details WHERE launchId = :launchId")
    suspend fun deleteByLaunchId(launchId: Int)
}