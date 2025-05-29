package com.tesla.spacextest.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteLaunchEntity(
    @PrimaryKey(autoGenerate = true)
    val launchId: Int,
    val launchDate: String,
    val name: String,
    val imageUrl: String
)
