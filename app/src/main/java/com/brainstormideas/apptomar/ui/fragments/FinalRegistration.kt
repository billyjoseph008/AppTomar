package com.brainstormideas.apptomar.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.brainstormideas.apptomar.R
import com.brainstormideas.apptomar.core.FirebaseAuthHelper
import com.brainstormideas.apptomar.data.models.User
import com.brainstormideas.apptomar.databinding.FragmentFinalRegistrationBinding
import com.brainstormideas.apptomar.sessions.RegisterSession
import com.brainstormideas.apptomar.sessions.RegisterSession.storeAddress
import com.brainstormideas.apptomar.sessions.RegisterSession.storeCity
import com.brainstormideas.apptomar.sessions.RegisterSession.storeCountry
import com.brainstormideas.apptomar.sessions.RegisterSession.storeEmail
import com.brainstormideas.apptomar.sessions.RegisterSession.storeName
import com.brainstormideas.apptomar.sessions.RegisterSession.storePhone
import com.brainstormideas.apptomar.sessions.RegisterSession.storeType
import com.brainstormideas.apptomar.sessions.RegisterSession.userAddress
import com.brainstormideas.apptomar.sessions.RegisterSession.userBirthDay
import com.brainstormideas.apptomar.sessions.RegisterSession.userCity
import com.brainstormideas.apptomar.sessions.RegisterSession.userCountry
import com.brainstormideas.apptomar.sessions.RegisterSession.userEmail
import com.brainstormideas.apptomar.sessions.RegisterSession.userGender
import com.brainstormideas.apptomar.sessions.RegisterSession.userID
import com.brainstormideas.apptomar.sessions.RegisterSession.userName
import com.brainstormideas.apptomar.sessions.RegisterSession.userPassword
import com.brainstormideas.apptomar.sessions.RegisterSession.userPhone
import com.brainstormideas.apptomar.sessions.RegisterSession.userType
import com.brainstormideas.apptomar.sessions.RegisterSession.vehicleBrand
import com.brainstormideas.apptomar.sessions.RegisterSession.vehicleColor
import com.brainstormideas.apptomar.sessions.RegisterSession.vehicleNumber
import com.brainstormideas.apptomar.sessions.RegisterSession.vehicleType
import com.brainstormideas.apptomar.ui.screens.REGISTER_PREFERENCE


class FinalRegistration : Fragment() {

    lateinit var preferences: SharedPreferences

    private var _binding: FragmentFinalRegistrationBinding? = null
    private val binding get() = _binding!!

    private val firebaseAuthHelper = FirebaseAuthHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        preferences = RegisterSession.customPreference(requireActivity(), REGISTER_PREFERENCE)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFinalRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (registerValidationCompleted()) {

            var user = User(
                0, preferences.userName!!, preferences.userEmail!!,
                preferences.userPassword!!, preferences.userPhone!!,
                preferences.userBirthDay!!, preferences.userCity!!,
                preferences.userGender!!, preferences.userAddress!!,
                preferences.userCountry!!, "",
                preferences.userID!!, preferences.userType!!
            )

            //firebaseAuthHelper.register(user)
            successRegisterAnimation(
                binding.successfullRegisterAnimationView,
                R.raw.check_mark_success_animation
            )
        }
    }

    private fun successRegisterAnimation(imageView: LottieAnimationView, animation: Int) {
        imageView.setAnimation(animation)
        imageView.repeatCount = 2
        imageView.playAnimation()
    }

    private fun registerValidationCompleted(): Boolean {

        var generalRegistration = false
        var specificRegistration = false

        if (!preferences.userEmail.isNullOrEmpty()
            && !preferences.userName.isNullOrEmpty()
            && !preferences.userPassword.isNullOrEmpty()
            && !preferences.userID.isNullOrEmpty()
            && !preferences.userAddress.isNullOrEmpty()
            && !preferences.userBirthDay.isNullOrEmpty()
            && !preferences.userCity.isNullOrEmpty()
            && !preferences.userCountry.isNullOrEmpty()
            && !preferences.userPhone.isNullOrEmpty()
            && !preferences.userGender.isNullOrEmpty()
        ) {
            generalRegistration = true
        }

        when (preferences.userType) {
            "client" -> {
                specificRegistration = true
            }
            "delivery" -> {
                if (!preferences.vehicleBrand.isNullOrEmpty()
                    && !preferences.vehicleColor.isNullOrEmpty()
                    && !preferences.vehicleNumber.isNullOrEmpty()
                    && !preferences.vehicleType.isNullOrEmpty()
                ) {
                    specificRegistration = true
                }
            }
            "store" -> {
                if (!preferences.storeAddress.isNullOrEmpty()
                    && !preferences.storeCity.isNullOrEmpty()
                    && !preferences.storeCountry.isNullOrEmpty()
                    && !preferences.storeEmail.isNullOrEmpty()
                    && !preferences.storeName.isNullOrEmpty()
                    && !preferences.storePhone.isNullOrEmpty()
                    && !preferences.storeType.isNullOrEmpty()
                ) {
                    specificRegistration = true
                }
            }
            else -> {
                specificRegistration = false
            }
        }
        return generalRegistration && specificRegistration
    }
}