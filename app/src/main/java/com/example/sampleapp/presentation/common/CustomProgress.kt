package com.example.sampleapp.presentation.common

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.example.sampleapp.R

class CustomProgress @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : View(
    context,
    attributeSet,
    defStyle
) {

    companion object {
        private const val START_DEGREES = 0F
        private const val STOP_DEGREES = 360F
        private const val ANIMATION_PIVOT_VALUE = 0.5F
        private const val ANIMATION_DURATION = 700L
    }

    private val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_logo)
    private val rectangle = Rect(0, 0, 500, 500)

    private val rotate = RotateAnimation(
        START_DEGREES,
        STOP_DEGREES,
        Animation.RELATIVE_TO_SELF,
        ANIMATION_PIVOT_VALUE,
        Animation.RELATIVE_TO_SELF,
        ANIMATION_PIVOT_VALUE
    )

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawBitmap(bitmap, null, rectangle, null)
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        rotate.duration = ANIMATION_DURATION
        rotate.repeatCount = Animation.INFINITE
        startAnimation(rotate)
    }
}