package com.example.sampleapp.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.sampleapp.R
import com.example.sampleapp.presentation.userlist.UserListActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashScreen : AppCompatActivity() {

    private val viewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        observe()
        viewModel.onCreated()
    }

    private fun observe() {
        viewModel.closeSplashTrigger.observe(this, Observer {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
            this.finish()
        })
    }
}