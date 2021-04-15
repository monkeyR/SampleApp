package com.example.sampleapp.presentation.userlist

import android.content.Context
import android.content.Intent
import com.example.sampleapp.domain.userlist.UserModel
import com.example.sampleapp.presentation.details.UserDetailsActivity

class UserListItem(val userModel: UserModel, private val context: Context) {

    fun onItemClicked() {
        val intent = Intent(context, UserDetailsActivity::class.java)
            .apply {
                putExtra(UserDetailsActivity.USER_ID_PARAM_NAME, userModel.id)
            }
        context.startActivity(intent)
    }
}

