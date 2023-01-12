package com.brainstormideas.apptomar.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.databinding.FragmentStoreMainScreenBinding
import com.brainstormideas.apptomar.managers.FragmentNavigationManager
import com.brainstormideas.apptomar.ui.fragments.store.DeliveryManRequest
import com.brainstormideas.apptomar.ui.fragments.store.Inventory
import com.brainstormideas.apptomar.ui.fragments.store.OpenedOrders
import com.brainstormideas.apptomar.ui.fragments.store.OrdersHistory


class StoreMainScreen : Fragment() {

    private var _binding: FragmentStoreMainScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var fragmentNavigationManager: FragmentNavigationManager
    private lateinit var fragmentStoreScreen: Fragment
    private val mainFragmentContainer = R.id.store_main_pages_fragment

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
        _binding = FragmentStoreMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentStoreScreen = OpenedOrders()
        fragmentNavigationManager.goToFragment(fragmentStoreScreen)
        binding.bottomNavigationStore.selectedItemId = R.id.opened_orders_page
        binding.bottomNavigationStore.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.inventory_page -> {
                    fragmentStoreScreen = Inventory()
                    fragmentNavigationManager.goToFragment(fragmentStoreScreen)
                }
                R.id.opened_orders_page -> {
                    fragmentStoreScreen = OpenedOrders()
                    fragmentNavigationManager.goToFragment(fragmentStoreScreen)
                }
                R.id.orders_history_page -> {
                    fragmentStoreScreen = OrdersHistory()
                    fragmentNavigationManager.goToFragment(fragmentStoreScreen)
                }
                R.id.deliveryMan_request_page -> {
                    fragmentStoreScreen = DeliveryManRequest()
                    fragmentNavigationManager.goToFragment(fragmentStoreScreen)
                }
                else -> {
                    fragmentStoreScreen = OpenedOrders()
                    fragmentNavigationManager.goToFragment(fragmentStoreScreen)
                }
            }
            true
        }
    }
}