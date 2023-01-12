package com.brainstormideas.apptomar.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainstormideas.apptomar.data.models.Store
import com.brainstormideas.apptomar.domain.GetStoresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val getStoresUseCase: GetStoresUseCase
) : ViewModel() {

    val storesModel = MutableLiveData<List<Store?>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        onCreate()
    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getStoresUseCase()
            if (!result.isNullOrEmpty()) {
                storesModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}