package com.example.sampleapp.presentation.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleapp.R

class UserDetailsActivity : AppCompatActivity() {

    companion object {
        const val USER_ID_PARAM_NAME = "USER_ID_PARAM_NAME"
        const val FRAGMENT_TAG = "USER_DETAILS_FRAGMENT_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val userId = intent.getIntExtra(USER_ID_PARAM_NAME, -1)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, UserDetailsFragment.getInstance(userId), FRAGMENT_TAG)
                .commit()

        }
    }
}