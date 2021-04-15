package com.example.sampleapp.presentation.common.bindingadapter

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.example.sampleapp.domain.common.Status
import com.example.sampleapp.domain.common.StatusResult

object BindingAdapter {

    @BindingAdapter("error")
    @JvmStatic
    fun <X> error(view: View, data: LiveData<StatusResult<X>>) {
        if (data.value?.status == Status.FINISHED && data.value?.isSuccess == false)
            view.visibility = View.VISIBLE
        else
            view.visibility = View.GONE
    }

    @BindingAdapter("progress")
    @JvmStatic
    fun <X> progress(view: ProgressBar, data: LiveData<StatusResult<X>>) {
        if (data.value?.status == Status.FINISHED)
            view.visibility = View.GONE
        else
            view.visibility = View.VISIBLE
    }

    @BindingAdapter("visibleOrGone")
    @JvmStatic
    fun <X> visibleOrGone(view: View, data: LiveData<X>) {
        if (data.value != null)
            view.visibility = View.VISIBLE
        else
            view.visibility = View.GONE
    }
}