package com.example.sampleapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.sampleapp.R
import com.example.sampleapp.presentation.splash.SplashScreen
import com.example.sampleapp.presentation.userlist.UserListActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observe()
    }

    private fun observe() {
        viewModel.goToSplashScreen.observe(this, Observer {
            val intent = Intent(this, SplashScreen::class.java)
            startActivity(intent)
            this.finish()
        })
        viewModel.goToMainScreen.observe(this, Observer {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
            this.finish()
        })

    }
}