package com.brainstormideas.apptomar.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.databinding.FragmentStoreUserFormBinding
import com.brainstormideas.apptomar.managers.FragmentNavigationManager
import com.brainstormideas.apptomar.sessions.RegisterSession
import com.brainstormideas.apptomar.sessions.RegisterSession.storeAddress
import com.brainstormideas.apptomar.sessions.RegisterSession.storeCity
import com.brainstormideas.apptomar.sessions.RegisterSession.storeCountry
import com.brainstormideas.apptomar.sessions.RegisterSession.storeCountryPosition
import com.brainstormideas.apptomar.sessions.RegisterSession.storeEmail
import com.brainstormideas.apptomar.sessions.RegisterSession.storeId
import com.brainstormideas.apptomar.sessions.RegisterSession.storeName
import com.brainstormideas.apptomar.sessions.RegisterSession.storePhone
import com.brainstormideas.apptomar.sessions.RegisterSession.storeType
import com.brainstormideas.apptomar.sessions.RegisterSession.userCountryPosition
import com.brainstormideas.apptomar.ui.screens.REGISTER_PREFERENCE


class StoreUserForm : Fragment() {

    private lateinit var preferences: SharedPreferences

    private var _binding: FragmentStoreUserFormBinding? = null
    private val binding get() = _binding!!

    private lateinit var fragmentNavigationManager: FragmentNavigationManager
    private lateinit var fragment: Fragment
    private val fragmentContainer = R.id.register_fragment_container

    private lateinit var storeType: String
    private lateinit var storeCountry: String

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
        _binding = FragmentStoreUserFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        storeCountry = preferences.storeCountry!!
        storeType = preferences.storeType!!
        changeStoreSelection(storeType)

        binding.registerStoreNameEditText.setText(preferences.storeName)
        binding.registerStoreEmailEditText.setText(preferences.storeEmail)
        binding.storePhoneEditText.setText(preferences.storePhone)
        binding.storeIdentificationEditText.setText(preferences.storeId)
        binding.storeCountrySpinner.setSelection(preferences.userCountryPosition)
        binding.registerStoreCityEditText.setText(preferences.storeCity)
        binding.registerStoreAddressEditText.setText(preferences.storeAddress)

        binding.registerStoreNameEditText.setOnFocusChangeListener { _, _ ->
            preferences.storeName = binding.registerStoreNameEditText.text.toString()
        }
        binding.registerStoreEmailEditText.setOnFocusChangeListener { _, _ ->
            preferences.storeEmail = binding.registerStoreEmailEditText.text.toString()
        }
        binding.storePhoneEditText.setOnFocusChangeListener { _, _ ->
            preferences.storePhone = binding.storePhoneEditText.text.toString()
        }
        binding.storeIdentificationEditText.setOnFocusChangeListener { _, _ ->
            preferences.storeId = binding.storeIdentificationEditText.text.toString()
        }

        binding.registerStoreCityEditText.setOnFocusChangeListener { _, _ ->
            preferences.storeCity = binding.registerStoreCityEditText.text.toString()
        }

        binding.registerStoreAddressEditText.setOnFocusChangeListener { _, _ ->
            preferences.storeAddress = binding.registerStoreAddressEditText.text.toString()
        }

        binding.storeCountrySpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                storeCountry = p0?.selectedItem.toString()
                preferences.storeCountry = storeCountry
                preferences.storeCountryPosition = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }

        binding.liquorStoreTypeImageButton.setOnClickListener {
            changeStoreSelection("store")
            preferences.storeType = "store"
        }
        binding.barStoreTypeImageButton.setOnClickListener {
            changeStoreSelection("bar")
            preferences.storeType = "bar"
        }
        binding.genericStoreTypeImageButton.setOnClickListener {
            changeStoreSelection("generic")
            preferences.storeType = "generic"
        }

        binding.finishStoreRegisterButton.setOnClickListener {
            if (validateForm().split("\n").size > 2) {
                binding.errorFormMessagesTextView.text = validateForm()
                binding.errorFormMessagesTextView.visibility = View.VISIBLE
            } else {
                fragment = FinalRegistration()
                fragmentNavigationManager.goToFragment(fragment)
            }
        }
    }

    private fun changeStoreSelection(storeType: String) {
        when (storeType) {
            "store" -> {
                binding.barStoreTypeImageButton.isEnabled = true
                binding.barStoreTypeImageButton.imageAlpha = 75
                binding.genericStoreTypeImageButton.isEnabled = true
                binding.genericStoreTypeImageButton.imageAlpha = 75
                binding.liquorStoreTypeImageButton.isEnabled = false
                binding.liquorStoreTypeImageButton.imageAlpha = 255
            }
            "bar" -> {
                binding.liquorStoreTypeImageButton.isEnabled = true
                binding.liquorStoreTypeImageButton.imageAlpha = 75
                binding.genericStoreTypeImageButton.isEnabled = true
                binding.genericStoreTypeImageButton.imageAlpha = 75
                binding.barStoreTypeImageButton.isEnabled = false
                binding.barStoreTypeImageButton.imageAlpha = 255
            }
            "generic" -> {
                binding.liquorStoreTypeImageButton.isEnabled = true
                binding.liquorStoreTypeImageButton.imageAlpha = 75
                binding.barStoreTypeImageButton.isEnabled = true
                binding.barStoreTypeImageButton.imageAlpha = 75
                binding.genericStoreTypeImageButton.isEnabled = false
                binding.genericStoreTypeImageButton.imageAlpha = 255
            }
            else -> {
                binding.barStoreTypeImageButton.isEnabled = true
                binding.barStoreTypeImageButton.imageAlpha = 75
                binding.genericStoreTypeImageButton.isEnabled = true
                binding.genericStoreTypeImageButton.imageAlpha = 75
                binding.liquorStoreTypeImageButton.isEnabled = false
                binding.liquorStoreTypeImageButton.imageAlpha = 255
            }
        }
    }

    private fun validateForm(): String {

        var correctionMessage = "Algunos campos no son correctos: \n"

        if (binding.registerStoreNameEditText.text.isNullOrEmpty()
            || binding.registerStoreNameEditText.text.length > 50
        ) {
            correctionMessage += "\n * Debes agregar un nombre. \n"
        }

        if (binding.registerStoreEmailEditText.text.isNullOrEmpty()
            || !(android.util.Patterns.EMAIL_ADDRESS
                .matcher(binding.registerStoreEmailEditText.text).matches())
        ) {
            correctionMessage += "\n * Email vacio o con formato incorrecto. \n"
        }

        if (binding.storePhoneEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar un numero de telefono \n"
        }

        if (binding.storeIdentificationEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar un numero de identificion/cedula \n"
        }

        if (storeCountry.isNullOrEmpty()) {
            correctionMessage += "\n * Debes elegir un pais \n"
        }

        if (binding.registerStoreCityEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar una ciudad/pueblo \n"
        }

        if (binding.registerStoreAddressEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar una direccion \n"
        }

        if (storeType.isNullOrEmpty()) {
            correctionMessage + "\n * Debes seleccionar un genero \n"
        }

        return correctionMessage
    }

}