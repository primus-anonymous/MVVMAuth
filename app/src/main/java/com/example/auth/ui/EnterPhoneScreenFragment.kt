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

class EnterPhoneScreenFragment : Fragment(R.layout.fragment_enter_phone) {

    companion object {
        const val TAG = "EnterPhoneScreenFragment"
    }

    private val authViewModel by activityViewModels<AuthViewModel>()

    private val enterPhoneViewModel by viewModels<EnterPhoneViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editPhone = view.findViewById<EditText>(R.id.edit_phone)
        val nextButton = view.findViewById<Button>(R.id.btn_next)

        enterPhoneViewModel.phoneInputCorrectLiveData.observe(viewLifecycleOwner, Observer {
            nextButton.isEnabled = it
        })

        editPhone.addTextChangedListener {
            val phone = it?.toString() ?: ""

            enterPhoneViewModel.onPhoneEntered(phone)
            authViewModel.phoneNumber = phone
        }

        nextButton.setOnClickListener {
            authViewModel.openPassword()
        }

        editPhone.setText(authViewModel.phoneNumber)
    }
}