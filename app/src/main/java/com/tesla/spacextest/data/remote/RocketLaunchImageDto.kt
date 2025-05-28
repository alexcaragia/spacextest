package com.tesla.spacextest.data.remote

import com.google.gson.annotations.SerializedName

data class RocketLaunchImageDto(
    @SerializedName("small") val smallImageUrl: String,
    @SerializedName("large") val largeImageUrl: String
)
