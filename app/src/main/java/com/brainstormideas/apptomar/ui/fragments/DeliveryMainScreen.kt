package com.brainstormideas.apptomar.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.databinding.FragmentDeliveryMainScreenBinding
import com.brainstormideas.apptomar.managers.FragmentNavigationManager
import com.brainstormideas.apptomar.ui.fragments.delivery.Deliveries
import com.brainstormideas.apptomar.ui.fragments.delivery.DeliveryOrdersHistory
import com.brainstormideas.apptomar.ui.fragments.delivery.DeliveryTeams


class DeliveryMainScreen : Fragment() {

    private var _binding: FragmentDeliveryMainScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var fragmentNavigationManager: FragmentNavigationManager
    private lateinit var fragmentDeliveryScreen: Fragment
    private val mainFragmentContainer = R.id.delivery_main_pages_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentNavigationManager = FragmentNavigationManager(
            mainFragmentContainer,
            parentFragmentManager
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeliveryMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDeliveryScreen = Deliveries()
        fragmentNavigationManager.goToFragment(fragmentDeliveryScreen)
        binding.bottomNavigationDelivery.selectedItemId = R.id.take_order_page
        binding.bottomNavigationDelivery.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.teams_page -> {
                    fragmentDeliveryScreen = DeliveryTeams()
                    fragmentNavigationManager.goToFragment(fragmentDeliveryScreen)
                }
                R.id.take_order_page -> {
                    fragmentDeliveryScreen = Deliveries()
                    fragmentNavigationManager.goToFragment(fragmentDeliveryScreen)
                }
                R.id.history_page -> {
                    fragmentDeliveryScreen = DeliveryOrdersHistory()
                    fragmentNavigationManager.goToFragment(fragmentDeliveryScreen)
                }
                else -> {
                    fragmentDeliveryScreen = Deliveries()
                    fragmentNavigationManager.goToFragment(fragmentDeliveryScreen)
                }
            }
            true
        }
    }
}