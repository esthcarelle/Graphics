package com.mine.graphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class DrawView : View {
    var paint: Paint = Paint()
    private fun init() {
        paint.color = Color.BLACK
    }

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

    override fun onDraw(canvas: Canvas) {
        paint.color = Color.BLACK
        canvas.drawLine(0F, 0f, 300f, 300f, paint)
        canvas.drawLine(300f, 0f, 0f, 300f, paint)
        paint.color = Color.BLUE
        canvas.drawCircle(150f, 150f, 100f, paint)
    }
}