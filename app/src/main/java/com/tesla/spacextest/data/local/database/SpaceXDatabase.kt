package com.tesla.spacextest.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tesla.spacextest.data.local.database.dao.FavoriteLaunchDetailsDao
import com.tesla.spacextest.data.local.database.dao.FavoritesLaunchDao

@Database(entities = [FavoriteLaunchEntity::class, FavoriteLaunchDetailsEntity::class], version = 1)
abstract class SpaceXDatabase : RoomDatabase() {
    abstract fun favoritesLaunchDao(): FavoritesLaunchDao
    abstract fun favoriteLaunchDetailsDao(): FavoriteLaunchDetailsDao
}