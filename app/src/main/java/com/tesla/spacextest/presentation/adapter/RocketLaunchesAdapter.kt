package com.tesla.spacextest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tesla.spacextest.databinding.ItemRocketLaunchBinding
import com.tesla.spacextest.domain.rocket.RocketLaunchDisplayData

class DefaultRocketLaunchesAdapter(
    private val onItemClick: (RocketLaunchDisplayData) -> Unit
) : RocketLaunchesAdapter<RocketLaunchDisplayData>(RocketLaunchesDiffUtilCallback(), onItemClick) {
    override fun update(newItems: List<RocketLaunchDisplayData>) {
        submitList(newItems)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): BaseViewHolder<RocketLaunchDisplayData> =
        RocketLaunchesItemViewHolder(
            ItemRocketLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: BaseViewHolder<RocketLaunchDisplayData>, position: Int) {
        holder.bind(currentList[position])
        holder.itemView.setOnClickListener {
            onItemClick(currentList[position])
        }
    }

    override fun getItemCount(): Int = currentList.size
}

class RocketLaunchesItemViewHolder(private val binding: ItemRocketLaunchBinding) :
    BaseViewHolder<RocketLaunchDisplayData>(binding.root) {
    override fun bind(listItem: RocketLaunchDisplayData) {
        binding.apply {
            tvLaunchDate.text = listItem.launchDate
            tvRocketName.text = listItem.name
            Glide.with(binding.root.context)
                .load(listItem.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)
                .into(ivRocketImage)
        }
    }
}