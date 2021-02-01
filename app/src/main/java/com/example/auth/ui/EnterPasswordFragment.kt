package com.example.auth.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.auth.R

class EnterPasswordFragment : Fragment(R.layout.fragment_enter_password) {

    companion object {
        const val TAG = "EnterPasswordFragment"
    }

    private val enterPasswordViewModel by viewModels<EnterPasswordViewModel>()

    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editPass = view.findViewById<EditText>(R.id.edit_pass)
        val nextButton = view.findViewById<Button>(R.id.btn_next)

        enterPasswordViewModel.passwordInputCorrectLiveData.observe(viewLifecycleOwner, Observer {
            nextButton.isEnabled = it
        })

        editPass.addTextChangedListener {
            val pass = it?.toString() ?: ""

            enterPasswordViewModel.onPasswordEntered(pass)
            authViewModel.password = pass
        }

        nextButton.setOnClickListener {
            authViewModel.doAuth()
        }

        editPass.setText(authViewModel.password)
    }
}