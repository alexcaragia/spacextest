package com.tesla.spacextest.data.mappers

import com.tesla.spacextest.data.remote.RocketLaunchInfoDto
import com.tesla.spacextest.domain.rocket.LaunchDisplayInfo
import com.tesla.spacextest.domain.rocket.RocketLaunchDisplayData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val DATE_FORMAT_PATTERN: String = "MMMM d, yyyy"

fun List<RocketLaunchInfoDto>.mapList(): List<RocketLaunchDisplayData> =
    this.map { it.toRocketLaunchDisplayData() }

private fun RocketLaunchInfoDto.toRocketLaunchDisplayData(): RocketLaunchDisplayData =
    RocketLaunchDisplayData(
        launchDisplayInfo = LaunchDisplayInfo(
            payloadMass = "",
            articleLink = this.launchDetails.wikipedia,
            launchDetails = this.details,
            youtubeId = this.launchDetails.youtubeId
        ),
        name = this.name,
        launchDate = this.launchDate.formatUnixDate(),
        imageUrl = this.launchDetails.image.largeImageUrl
    )

private fun Long.formatUnixDate(): String {
    val date = Date(this * 1000)
    val format = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ENGLISH)
    return format.format(date)
}