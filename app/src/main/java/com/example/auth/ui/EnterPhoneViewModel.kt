package com.example.auth.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnterPhoneViewModel : ViewModel() {

    companion object {
        private const val PHONE_LENGTH = 10
    }

    private val _phoneInputCorrectLiveData = MutableLiveData<Boolean>(false)

    val phoneInputCorrectLiveData: LiveData<Boolean> = _phoneInputCorrectLiveData

    fun onPhoneEntered(phone: String) {
        _phoneInputCorrectLiveData.value = phone.length == PHONE_LENGTH && phone.startsWith("9")
    }
}