package com.tesla.spacextest.data.remote

import com.google.gson.annotations.SerializedName

data class RocketLaunchInfoDto(
    @SerializedName("name") val name: String,
    @SerializedName("date_unix") val launchDate: Long,
    @SerializedName("details") val details: String,
    @SerializedName("links") val launchDetails: RocketLaunchLinksDto,
    @SerializedName("payloads") val payloads: List<String>
)