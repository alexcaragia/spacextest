package com.tesla.spacextest.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tesla.spacextest.databinding.FragmentLaunchBinding
import com.tesla.spacextest.presentation.adapter.DefaultRocketLaunchesAdapter
import com.tesla.spacextest.presentation.state.RocketLaunchesState
import com.tesla.spacextest.presentation.viewmodel.RocketLaunchesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RocketLaunchesFragment : Fragment() {
    private lateinit var binding: FragmentLaunchBinding
    private lateinit var rocketLaunchesAdapter: DefaultRocketLaunchesAdapter
    private val viewModel by viewModel<RocketLaunchesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaunchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadRocketLaunches()
        setupViews()
        observeStateChanges()
    }

    private fun setupViews() {
        rocketLaunchesAdapter = DefaultRocketLaunchesAdapter { rocketLaunchDisplayData ->
            val navigateToDetailsAction =
                RocketLaunchesFragmentDirections.actionRocketLaunchesFragmentToLaunchDetailsFragment(
                    rocketLaunchDisplayData
                )
            findNavController().navigate(navigateToDetailsAction)
        }
        binding.rvRocketLaunches.run {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = rocketLaunchesAdapter
        }
    }

    private fun observeStateChanges() {
        viewModel.rocketLaunchesState.observe(viewLifecycleOwner) {
            when(it) {
                RocketLaunchesState.Loading -> {
                    binding.apply {
                        rvRocketLaunches.isVisible = false
                        pbLoading.isVisible = true
                    }
                }
                is RocketLaunchesState.CurrentRocketLaunches -> {
                    binding.pbLoading.isVisible = false
                    binding.rvRocketLaunches.isVisible = true
                    rocketLaunchesAdapter.update(it.data)
                }
                is RocketLaunchesState.Error -> {

                }
            }
        }
    }
}