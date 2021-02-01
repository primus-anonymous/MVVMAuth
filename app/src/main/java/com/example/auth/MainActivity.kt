package com.example.auth

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.auth.ui.AuthActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        private const val AUTH_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.btn_auth).setOnClickListener {
            Intent(this, AuthActivity::class.java).also {
                startActivityForResult(it, AUTH_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == AUTH_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, R.string.authorized, Toast.LENGTH_LONG).show()
            }
        }
    }
}