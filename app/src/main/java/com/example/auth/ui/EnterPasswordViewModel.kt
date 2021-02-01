package com.example.auth.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnterPasswordViewModel : ViewModel() {

    companion object {
        private const val MIN_PASS_LENGTH = 4
    }

    private val _passwordInputCorrectLiveData = MutableLiveData<Boolean>(false)

    val passwordInputCorrectLiveData: LiveData<Boolean> = _passwordInputCorrectLiveData

    fun onPasswordEntered(pass: String) {
        _passwordInputCorrectLiveData.value = pass.length >= MIN_PASS_LENGTH
    }
}