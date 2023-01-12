package com.brainstormideas.apptomar.ui.screens

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.databinding.ActivityMainBinding
import com.brainstormideas.apptomar.managers.FragmentNavigationManager
import com.brainstormideas.apptomar.ui.fragments.ClientMainScreen
import com.brainstormideas.apptomar.ui.fragments.DeliveryMainScreen
import com.brainstormideas.apptomar.ui.fragments.StoreMainScreen
import com.brainstormideas.apptomar.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

const val GLOBAL_PREFERENCE = "GLOBAL_PREFERENCE"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentNavigationManager: FragmentNavigationManager
    private lateinit var fragmentMainScreen: Fragment
    private val userViewModel: UserViewModel by viewModels()
    private val mainFragmentContainer = R.id.main_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    override fun onBackPressed() {

    }

    private fun setup() {

        fragmentNavigationManager = FragmentNavigationManager(
            mainFragmentContainer,
            supportFragmentManager
        )

        userViewModel.isLoading.observe(this, Observer { loading ->
            binding.progressBar.isVisible = loading
        })

        userViewModel.userModel.observe(this, Observer { currentUser ->
            when (currentUser?.type) {
                "client" -> {
                    fragmentMainScreen = ClientMainScreen()
                    fragmentNavigationManager.goToFragment(fragmentMainScreen)
                }
                "deliveryMan" -> {
                    fragmentMainScreen = DeliveryMainScreen()
                    fragmentNavigationManager.goToFragment(fragmentMainScreen)
                }
                "store" -> {
                    fragmentMainScreen = StoreMainScreen()
                    fragmentNavigationManager.goToFragment(fragmentMainScreen)
                }
                else -> {
                    fragmentMainScreen = ClientMainScreen()
                    fragmentNavigationManager.goToFragment(fragmentMainScreen)
                }
            }
        })
    }
}