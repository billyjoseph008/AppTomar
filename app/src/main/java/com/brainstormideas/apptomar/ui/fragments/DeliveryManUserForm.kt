package com.brainstormideas.apptomar.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.databinding.FragmentDeliveryManUserFormBinding
import com.brainstormideas.apptomar.managers.FragmentNavigationManager
import com.brainstormideas.apptomar.sessions.RegisterSession
import com.brainstormideas.apptomar.sessions.RegisterSession.vehicleBrand
import com.brainstormideas.apptomar.sessions.RegisterSession.vehicleColor
import com.brainstormideas.apptomar.sessions.RegisterSession.vehicleNumber
import com.brainstormideas.apptomar.sessions.RegisterSession.vehicleType
import com.brainstormideas.apptomar.ui.screens.REGISTER_PREFERENCE

class DeliveryManUserForm : Fragment() {

    private lateinit var preferences: SharedPreferences

    private var _binding: FragmentDeliveryManUserFormBinding? = null
    private val binding get() = _binding!!

    private lateinit var fragmentNavigationManager: FragmentNavigationManager
    private lateinit var fragment: Fragment
    private val fragmentContainer = R.id.register_fragment_container

    private lateinit var vehicleType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = RegisterSession.customPreference(requireActivity(), REGISTER_PREFERENCE)
        fragmentNavigationManager =
            FragmentNavigationManager(fragmentContainer, parentFragmentManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeliveryManUserFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vehicleType = preferences.vehicleType!!
        changeVehicleSelection(vehicleType)

        binding.registerVehicleBrandEditText.setText(preferences.vehicleBrand)
        binding.registerVehicleColorEditText.setText(preferences.vehicleColor)
        binding.registerVehicleNumberEditText.setText(preferences.vehicleNumber)

        binding.registerVehicleBrandEditText.setOnFocusChangeListener { _, _ ->
            preferences.vehicleBrand = binding.registerVehicleBrandEditText.text.toString()
        }
        binding.registerVehicleColorEditText.setOnFocusChangeListener { _, _ ->
            preferences.vehicleColor = binding.registerVehicleColorEditText.text.toString()
        }
        binding.registerVehicleNumberEditText.setOnFocusChangeListener { _, _ ->
            preferences.vehicleNumber = binding.registerVehicleNumberEditText.text.toString()
        }

        binding.vehicleBikeImageButton.setOnClickListener {
            changeVehicleSelection("bike")
            preferences.vehicleType = "bike"
        }
        binding.vehicleCarImageButton.setOnClickListener {
            changeVehicleSelection("car")
            preferences.vehicleType = "car"
        }

        binding.finishDeliveryRegisterButton.setOnClickListener {
            if (validateForm().split("\n").size > 2) {
                binding.errorFormMessagesTextView.text = validateForm()
                binding.errorFormMessagesTextView.visibility = View.VISIBLE
            } else {
                fragment = FinalRegistration()
                fragmentNavigationManager.goToFragment(fragment)
            }
        }
    }

    private fun changeVehicleSelection(vehicle: String) {
        if (vehicle == "bike") {
            binding.vehicleCarImageButton.isEnabled = true
            binding.vehicleCarImageButton.imageAlpha = 75
            binding.vehicleBikeImageButton.isEnabled = false
            binding.vehicleBikeImageButton.imageAlpha = 255
        } else if (vehicle == "car") {
            binding.vehicleBikeImageButton.isEnabled = true
            binding.vehicleBikeImageButton.imageAlpha = 75
            binding.vehicleCarImageButton.isEnabled = false
            binding.vehicleCarImageButton.imageAlpha = 255
        }
    }

    private fun validateForm(): String {

        var correctionMessage = "Algunos campos no son correctos: \n"

        if (binding.registerVehicleBrandEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar la marca del vehiculo. \n"
        }

        if (binding.registerVehicleColorEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar color del vehiculo. \n"
        }

        if (binding.registerVehicleNumberEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar una placa. \n"
        }

        if (vehicleType.isNullOrEmpty()) {
            correctionMessage + "\n * Debes seleccionar un tipo de vehiculo. \n"
        }

        return correctionMessage
    }
}