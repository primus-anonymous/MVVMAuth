package com.example.auth.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.random.Random

class AuthViewModel : ViewModel() {

    private val _authSucceedLiveData = MutableLiveData<Boolean>(false)
    private val _openPasswordLiveData = MutableLiveData<Boolean>(false)

    val authSucceedLiveData: LiveData<Boolean> = _authSucceedLiveData
    val openPasswordLiveData: LiveData<Boolean> = _openPasswordLiveData

    var password = ""

    var phoneNumber = ""

    fun openPassword() {
        _openPasswordLiveData.value = true
    }

    fun doAuth() {
        _authSucceedLiveData.value = true
    }

    fun passwordOpened() {
        _openPasswordLiveData.value = false
    }
}