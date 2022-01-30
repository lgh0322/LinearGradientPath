package com.vaca.myapplication

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import android.graphics.RectF

import android.graphics.Shader.TileMode

import android.graphics.LinearGradient

import android.graphics.Shader






class BatteryView : View {
    var canvas: Canvas? = null
    var batteryValue = 100
    private var data: Int = 33
    private val wavePaint = Paint()

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    private fun init() {
        wavePaint.apply {
            color = getColor(R.color.battery_black)
            style = Paint.Style.FILL
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.canvas = canvas
        drawWave(canvas)

    }


    private fun drawWave(canvas: Canvas) {
        canvas.drawColor(getColor(R.color.white))

        val xx = BitmapFactory.Options()
        xx.inScaled = false
        xx.inPreferredConfig = Bitmap.Config.ARGB_8888

        val mi = BitmapFactory.decodeResource(resources, R.drawable.home_power_icon, xx)


        val x1 = 0f
        val y1 = 0f
        val x2 = 100f
        val y2 = 40f
        val shader: Shader =
            LinearGradient(0f, 0f, 200f, 400f, Color.BLACK, Color.WHITE, TileMode.CLAMP)
        val paint = Paint()
        paint.shader = shader
//        canvas.drawRect(RectF(x1.toFloat(), y1.toFloat(), x2.toFloat(), y2.toFloat()), paint)
        val gg=Path()
        gg.moveTo(200f,200f)
        gg.lineTo(300f,220f)
        gg.lineTo(300f,400f)
        gg.lineTo(200f,400f)
        gg.lineTo(200f,200f)
//        gg.close()
//        paint.color=Color.BLACK
        paint.strokeWidth=1f
        paint.style=Paint.Style.FILL_AND_STROKE
        canvas.drawPath(gg,paint)
        paint.shader =   LinearGradient(200f, 200f, 400f, 400f, Color.YELLOW, Color.RED, TileMode.CLAMP)
        paint.style=Paint.Style.STROKE
        paint.strokeWidth=10f
        canvas.drawLine(200f,200f,400f,400f,paint)
    }

    private fun getColor(resource_id: Int): Int {
        return ContextCompat.getColor(context, resource_id)
    }
}