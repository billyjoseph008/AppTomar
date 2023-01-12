package com.brainstormideas.apptomar.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.databinding.FragmentClientMainScreenBinding
import com.brainstormideas.apptomar.managers.FragmentNavigationManager
import com.brainstormideas.apptomar.ui.fragments.client.ClientOrdersHistory
import com.brainstormideas.apptomar.ui.fragments.client.Favorites
import com.brainstormideas.apptomar.ui.fragments.client.NewOrder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientMainScreen : Fragment() {

    private var _binding: FragmentClientMainScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var fragmentNavigationManager: FragmentNavigationManager
    private lateinit var fragmentClientScreen: Fragment
    private val mainFragmentContainer = R.id.client_main_pages_fragment

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
        _binding = FragmentClientMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentClientScreen = NewOrder()
        fragmentNavigationManager.goToFragment(fragmentClientScreen)
        binding.bottomNavigationClient.selectedItemId = R.id.new_order_page
        binding.bottomNavigationClient.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.favorite_page -> {
                    fragmentClientScreen = Favorites()
                    fragmentNavigationManager.goToFragment(fragmentClientScreen)
                }
                R.id.new_order_page -> {
                    fragmentClientScreen = NewOrder()
                    fragmentNavigationManager.goToFragment(fragmentClientScreen)
                }
                R.id.historial_page -> {
                    fragmentClientScreen = ClientOrdersHistory()
                    fragmentNavigationManager.goToFragment(fragmentClientScreen)
                }
                else -> {
                    fragmentClientScreen = NewOrder()
                    fragmentNavigationManager.goToFragment(fragmentClientScreen)
                }
            }
            true
        }
    }
}