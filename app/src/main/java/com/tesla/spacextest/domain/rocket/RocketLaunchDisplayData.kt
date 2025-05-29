package com.tesla.spacextest.domain.rocket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RocketLaunchDisplayData(
    val name: String?,
    val launchDate: String?,
    val imageUrl: String?,
    val launchDisplayInfo: LaunchDisplayInfo?
) : Parcelable

@Parcelize
data class LaunchDisplayInfo(
    val payloadMass: String?,
    val articleLink: String?,
    val launchDetails: String?,
    val youtubeId: String
) : Parcelable


