package com.tesla.spacextest.data.remote

import com.google.gson.annotations.SerializedName

data class RocketLaunchLinksDto(
    @SerializedName("patch") val image: RocketLaunchImageDto,
    @SerializedName("youtube_id") val youtubeId: String,
    @SerializedName("wikipedia") val wikipedia: String
)
