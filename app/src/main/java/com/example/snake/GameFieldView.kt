package com.example.snake

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class GameFieldView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private var pairs: List<Pair<Int, Int>> = arrayListOf()
    private var position: Int = 0
    private var lenght: Float = 0f
    private lateinit var canvas: Canvas

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        this.canvas = canvas

        var bp = Paint()
        bp.color = Color.RED
        for (i in pairs) {
            canvas.drawRect(lenght * i.second, lenght * i.first, lenght + lenght * i.second, lenght + lenght * i.first, bp)
        }


        val p = Paint()
        p.color = Color.BLACK
        p.strokeWidth = 1f

        lenght = width.toFloat() / 10

        for (i in 0..10)
            canvas.drawLine(lenght * i, 0f, lenght * i, width.toFloat(), p)

        for (i in 0..10)
            canvas.drawLine(0f, lenght * i, width.toFloat(), lenght * i, p)
    }

    fun setSnakePosition(pairs: List<Pair<Int, Int>>) {
        this.pairs = pairs
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
//        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
//
//        if (widthSize == 0 && heightSize == 0) {
//            // If there are no constraints on size, let FrameLayout measure
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//
//            // Now use the smallest of the measured dimensions for both dimensions
//            val minSize = Math.min(measuredWidth, measuredHeight)
//            setMeasuredDimension(minSize, minSize)
//            return
//        }
//
//        val size: Int
//        if (widthSize == 0 || heightSize == 0) {
//            // If one of the dimensions has no restriction on size, set both dimensions to be the
//            // on that does
//            size = Math.max(widthSize, heightSize)
//        } else {
//            // Both dimensions have restrictions on size, set both dimensions to be the
//            // smallest of the two
//            size = Math.min(widthSize, heightSize)
//        }
//
//        val newMeasureSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY)
//        super.onMeasure(newMeasureSpec, newMeasureSpec)
//    }

}