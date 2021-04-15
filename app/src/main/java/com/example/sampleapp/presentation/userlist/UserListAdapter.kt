package com.example.sampleapp.presentation.userlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.R
import com.example.sampleapp.databinding.ItemUserDetailsBinding
import com.example.sampleapp.domain.userlist.UserModel
import kotlin.properties.Delegates

class UserListAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<UserModel> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemUserDetailsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_user_details,
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).onBind(
            UserListItem(
                items[position],
                context
            )
        )
    }

    private inner class UserViewHolder(private val dataBinding: ItemUserDetailsBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun onBind(itemViewModel: UserListItem) {
            dataBinding.item = itemViewModel
        }
    }
}