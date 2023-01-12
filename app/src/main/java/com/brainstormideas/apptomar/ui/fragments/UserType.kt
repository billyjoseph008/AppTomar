package com.brainstormideas.apptomar.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.databinding.FragmentUserTypeBinding
import com.brainstormideas.apptomar.managers.FragmentNavigationManager
import com.brainstormideas.apptomar.sessions.RegisterSession.customPreference
import com.brainstormideas.apptomar.sessions.RegisterSession.userType
import com.brainstormideas.apptomar.ui.screens.CLIENT
import com.brainstormideas.apptomar.ui.screens.DELIVERY
import com.brainstormideas.apptomar.ui.screens.REGISTER_PREFERENCE
import com.brainstormideas.apptomar.ui.screens.STORE

class UserType : Fragment() {

    private var _binding: FragmentUserTypeBinding? = null
    private val binding get() = _binding!!

    private lateinit var fragmentNavigationManager: FragmentNavigationManager
    private val fragmentContainer = R.id.register_fragment_container


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentNavigationManager =
            FragmentNavigationManager(fragmentContainer, parentFragmentManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferences = customPreference(requireActivity(), REGISTER_PREFERENCE)
        val fragment = UserDataForm()
        binding.clientImageButton.setOnClickListener {
            fragmentNavigationManager.goToFragmentWithData(fragment, CLIENT)
            preferences.userType = CLIENT
        }

        binding.deliveryManImageButton.setOnClickListener {
            fragmentNavigationManager.goToFragmentWithData(fragment, DELIVERY)
            preferences.userType = DELIVERY
        }

        binding.storeImageButton.setOnClickListener {
            fragmentNavigationManager.goToFragmentWithData(fragment, STORE)
            preferences.userType = STORE
        }
    }
}