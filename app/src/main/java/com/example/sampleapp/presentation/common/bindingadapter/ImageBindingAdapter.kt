package com.example.sampleapp.presentation.common.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.sampleapp.R

object ImageBindingAdapter {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(image: ImageView, url: String?) {
        url?.let {
            Glide.with(image.context)
                .load(url)
                .placeholder(R.drawable.ic_placeholder)
                .into(image)
        }
    }
}