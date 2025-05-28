package com.tesla.spacextest.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tesla.spacextest.domain.rocket.RocketLaunchDisplayData

class RocketLaunchesDiffUtilCallback : DiffUtil.ItemCallback<RocketLaunchDisplayData>() {
    override fun areItemsTheSame(
        oldItem: RocketLaunchDisplayData, newItem: RocketLaunchDisplayData
    ): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: RocketLaunchDisplayData, newItem: RocketLaunchDisplayData
    ): Boolean = oldItem == newItem
}