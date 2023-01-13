package com.brainstormideas.apptomar.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.core.FirebaseAuthHelper
import com.brainstormideas.apptomar.databinding.FragmentUserDataFormBinding
import com.brainstormideas.apptomar.managers.FragmentNavigationManager
import com.brainstormideas.apptomar.managers.MessagesManager
import com.brainstormideas.apptomar.managers.ScreenManager
import com.brainstormideas.apptomar.sessions.RegisterSession
import com.brainstormideas.apptomar.sessions.RegisterSession.userAddress
import com.brainstormideas.apptomar.sessions.RegisterSession.userBirthDay
import com.brainstormideas.apptomar.sessions.RegisterSession.userCity
import com.brainstormideas.apptomar.sessions.RegisterSession.userCountry
import com.brainstormideas.apptomar.sessions.RegisterSession.userCountryPosition
import com.brainstormideas.apptomar.sessions.RegisterSession.userEmail
import com.brainstormideas.apptomar.sessions.RegisterSession.userGender
import com.brainstormideas.apptomar.sessions.RegisterSession.userID
import com.brainstormideas.apptomar.sessions.RegisterSession.userName
import com.brainstormideas.apptomar.sessions.RegisterSession.userPassword
import com.brainstormideas.apptomar.sessions.RegisterSession.userPhone
import com.brainstormideas.apptomar.sessions.RegisterSession.userSecondPassword
import com.brainstormideas.apptomar.sessions.RegisterSession.userType
import com.brainstormideas.apptomar.ui.fragments.utils.PasswordUtils
import com.brainstormideas.apptomar.ui.screens.INPUT_DATA
import com.brainstormideas.apptomar.ui.screens.REGISTER_PREFERENCE
import kotlinx.coroutines.launch

class UserDataForm : Fragment() {

    private lateinit var preferences: SharedPreferences

    private var _binding: FragmentUserDataFormBinding? = null
    private val binding get() = _binding!!

    private lateinit var fragmentNavigationManager: FragmentNavigationManager
    private lateinit var fragment: Fragment
    private val fragmentContainer = R.id.register_fragment_container

    private val firebaseAuthHelper = FirebaseAuthHelper()

    private lateinit var screenManager: ScreenManager
    private lateinit var messageManager: MessagesManager

    private lateinit var userBirthDay: String
    private lateinit var userGender: String
    private lateinit var userCountry: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screenManager = ScreenManager(requireActivity().applicationContext)
        messageManager = MessagesManager(requireActivity().applicationContext)
        preferences = RegisterSession.customPreference(requireActivity(), REGISTER_PREFERENCE)
        fragmentNavigationManager =
            FragmentNavigationManager(fragmentContainer, parentFragmentManager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDataFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formType = requireArguments().getString(INPUT_DATA)
        preferences.userType = formType

        userCountry = preferences.userCountry!!
        userBirthDay = preferences.userBirthDay!!
        userGender = preferences.userGender!!
        changeGenderSelection(userGender)

        binding.registerNameEditText.setText(preferences.userName)
        binding.registerEmailEditText.setText(preferences.userEmail)
        binding.registerPasswordEditText.setText(preferences.userPassword)
        binding.secondRegisterPasswordEditText.setText(preferences.userSecondPassword)
        binding.registerUserPhoneEditText.setText(preferences.userPhone)
        binding.identificationEditText.setText(preferences.userID)
        binding.countrySpinner.setSelection(preferences.userCountryPosition)
        binding.registerUserCityEditText.setText(preferences.userCity)
        binding.registerAddressEditText.setText(preferences.userAddress)
        binding.registerBirthDayEditText.setText(preferences.userBirthDay)
        binding.errorFormMessagesTextView.visibility = View.GONE

        binding.registerNameEditText.setOnFocusChangeListener { _, _ ->
            preferences.userName = binding.registerNameEditText.text.toString()
        }
        binding.registerEmailEditText.setOnFocusChangeListener { _, _ ->
            preferences.userEmail = binding.registerEmailEditText.text.toString()
        }
        binding.registerPasswordEditText.setOnFocusChangeListener { _, _ ->
            preferences.userPassword = binding.registerPasswordEditText.text.toString()
        }
        binding.secondRegisterPasswordEditText.setOnFocusChangeListener { _, _ ->
            preferences.userSecondPassword = binding.secondRegisterPasswordEditText.text.toString()
        }
        binding.registerUserPhoneEditText.setOnFocusChangeListener { _, _ ->
            preferences.userPhone = binding.registerUserPhoneEditText.text.toString()
        }
        binding.identificationEditText.setOnFocusChangeListener { _, _ ->
            preferences.userID = binding.identificationEditText.text.toString()
        }
        binding.countrySpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                userCountry = p0?.selectedItem.toString()
                preferences.userCountry = userCountry
                preferences.userCountryPosition = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }
        binding.registerUserCityEditText.setOnFocusChangeListener { _, _ ->
            preferences.userCity = binding.registerUserCityEditText.text.toString()
        }
        binding.registerAddressEditText.setOnFocusChangeListener { _, _ ->
            preferences.userAddress = binding.registerAddressEditText.text.toString()
        }
        binding.registerBirthDayEditText.setOnClickListener {
            showDatePickerDialog()
        }
        binding.genderMaleImageButton.setOnClickListener {
            changeGenderSelection("male")
            preferences.userGender = "male"
        }
        binding.genderFemaleImageButton.setOnClickListener {
            changeGenderSelection("female")
            preferences.userGender = "female"
        }
        binding.continueSpecialMenuButton.setOnClickListener {
            lifecycleScope.launch {
                FinalRegistration()
                if (validateForm().split("\n").size > 2) {
                    binding.errorFormMessagesTextView.text = validateForm()
                    binding.errorFormMessagesTextView.visibility = View.VISIBLE
                } else {
                    fragment = when (preferences.userType) {
                        "client" -> FinalRegistration()
                        "delivery" -> DeliveryManUserForm()
                        "store" -> StoreUserForm()
                        else -> {
                            FinalRegistration()
                        }
                    }
                    fragmentNavigationManager.goToFragment(fragment)
                }
            }
        }
    }

    private fun showDatePickerDialog() {
        val datePickerFragment =
            DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePickerFragment.show(parentFragmentManager, "datePickerFragment")

    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        val pickedBirthDay = "$day/$month/$year"
        binding.registerBirthDayEditText.setText(pickedBirthDay)
        preferences.userBirthDay = pickedBirthDay
    }

    private fun changeGenderSelection(gender: String) {
        if (gender == "male") {
            binding.genderFemaleImageButton.isEnabled = true
            binding.genderFemaleImageButton.imageAlpha = 75
            binding.genderMaleImageButton.isEnabled = false
            binding.genderMaleImageButton.imageAlpha = 255
        } else if (gender == "female") {
            binding.genderMaleImageButton.isEnabled = true
            binding.genderMaleImageButton.imageAlpha = 75
            binding.genderFemaleImageButton.isEnabled = false
            binding.genderFemaleImageButton.imageAlpha = 255
        }
    }

    private suspend fun validateForm(): String {

        var correctionMessage = "Algunos campos no son correctos: \n"

        if (binding.registerNameEditText.text.isNullOrEmpty()
            || binding.registerNameEditText.text.length > 50
        ) {
            correctionMessage += "\n * Debes agregar un nombre. \n"
        }

        if (binding.registerEmailEditText.text.isNullOrEmpty()
            || !(android.util.Patterns.EMAIL_ADDRESS
                .matcher(binding.registerEmailEditText.text).matches())
        ) {
            correctionMessage += "\n * Email vacio o con formato incorrecto. \n"
        }

        if (!firebaseAuthHelper.checkIfEmailIsAvailable(binding.registerEmailEditText.text.toString())) {
            correctionMessage += "\n * Email en uso. \n"
        }

        if (binding.registerPasswordEditText.text.isNullOrEmpty()
            || binding.registerPasswordEditText.text.length < 8
            || PasswordUtils.isValidPassword(binding.registerPasswordEditText.text.toString())
        ) {
            correctionMessage += "\n * Tu contrasena debe ser mayor a 8 caracteres, " +
                    "debe contener una letra minuscula, una minuscula, un numero y un caracter especial. \n"
        }

        if (binding.registerPasswordEditText.text.toString().trim()
            != binding.secondRegisterPasswordEditText.text.toString().trim()
        ) {
            correctionMessage += "\n * Las contrasenas no coinciden. \n"
        }

        if (binding.registerUserPhoneEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar un numero de telefono \n"
        }

        if (binding.identificationEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar un numero de identificion/cedula \n"
        }

        if (userCountry.isEmpty()) {
            correctionMessage += "\n * Debes elegir un pais \n"
        }

        if (binding.registerUserCityEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar una ciudad/pueblo \n"
        }

        if (binding.registerAddressEditText.text.isNullOrEmpty()) {
            correctionMessage += "\n * Debes agregar una direccion \n"
        }

        if (userBirthDay.isEmpty()) {
            correctionMessage += "\n * Debes seleccionar una fecha de nacimiento \n"
        }

        if (userGender.isEmpty()) {
            correctionMessage += "\n * Debes seleccionar un genero \n"
        }

        return correctionMessage
    }
}