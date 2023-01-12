package com.brainstormideas.apptomar.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainstormideas.apptomar.data.models.User
import com.brainstormideas.apptomar.domain.GetUserInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserInformationUseCase: GetUserInformationUseCase,
) : ViewModel() {

    val userModel = MutableLiveData<User?>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        onCreate()
    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            if (!userModel.value.toString().isNullOrEmpty()) {
                userModel.value = getUserInformationUseCase()
                isLoading.postValue(false)
            }
        }
    }
}