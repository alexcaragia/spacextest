package com.tesla.spacextest.data.local.mappers

import com.tesla.spacextest.data.local.database.entities.FavoriteLaunchDetailsEntity
import com.tesla.spacextest.data.local.database.entities.FavoriteLaunchEntity
import com.tesla.spacextest.domain.rocket.LaunchDisplayInfo
import com.tesla.spacextest.domain.rocket.RocketLaunchDisplayData

fun FavoriteLaunchEntity.toDisplayData(details: FavoriteLaunchDetailsEntity): RocketLaunchDisplayData =
    RocketLaunchDisplayData(
        name = this.name,
        launchDate = this.launchDate,
        imageUrl = this.imageUrl,
        launchDisplayInfo = LaunchDisplayInfo(
            payloadMass = details.payloadMass,
            articleLink = details.articleLink,
            launchDetails = details.launchDetails,
            youtubeId = details.youtubeId
        )
    )
