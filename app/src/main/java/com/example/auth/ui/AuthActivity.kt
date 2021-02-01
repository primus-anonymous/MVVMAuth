package com.example.auth.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.auth.R

class AuthActivity : AppCompatActivity(R.layout.activity_auth) {

    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragmentContainer,
                    EnterPhoneScreenFragment(),
                    EnterPhoneScreenFragment.TAG
                )
                .commit()
        }

        authViewModel.authSucceedLiveData.observe(this, Observer { result ->
            if (result == true) {
                setResult(Activity.RESULT_OK)
                finish()
            }
        })

        authViewModel.openPasswordLiveData.observe(this, Observer { openPassword ->
            if (openPassword == true) {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragmentContainer,
                        EnterPasswordFragment(),
                        EnterPasswordFragment.TAG
                    )
                    .addToBackStack(EnterPasswordFragment.TAG)
                    .commit()

                authViewModel.passwordOpened()
            }
        })
    }
}