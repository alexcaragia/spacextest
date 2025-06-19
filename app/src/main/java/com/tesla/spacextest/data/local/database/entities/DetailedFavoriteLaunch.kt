package com.tesla.spacextest.data.local.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class DetailedFavoriteLaunch(
    @Embedded val favoriteLaunch: FavoriteLaunchEntity,

    @Relation(
        parentColumn = "launchId",
        entityColumn = "launchId"
    )
    val details: FavoriteLaunchEntity
)
