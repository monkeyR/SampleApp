package com.example.sampleapp.presentation.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.example.sampleapp.domain.Status
import com.example.sampleapp.domain.StatusResult

object BindingAdapter {

    @BindingAdapter("error")
    @JvmStatic
    fun <X> error(view: View, data: LiveData<StatusResult<X>>) {
        if (data.value?.status == Status.FINISHED && data.value?.isSuccess == false)
            view.visibility = View.VISIBLE
        else
            view.visibility = View.GONE
    }
}