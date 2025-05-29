package com.tesla.spacextest.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "launch_details")
data class FavoriteLaunchDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val payloadMass: String,
    val articleLink: String,
    val launchDetails: String,
    val youtubeId: String,
    val launchId: String
)
