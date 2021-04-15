package com.example.sampleapp.presentation.common

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

class DateFormatter {

    companion object {
        private const val DATE_PATTERN = "dd-MM-yyyy"
    }

    @SuppressLint("SimpleDateFormat")
    fun parseDate(date: String) = SimpleDateFormat(DATE_PATTERN).parse(date)!!
}