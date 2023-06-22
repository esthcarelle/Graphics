package com.mine.graphics

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FacebookIcon() {
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
        typeface = ResourcesCompat.getFont(LocalContext.current, R.font.facebolf)
    }
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            color = Color(0xFF1776d1),
            cornerRadius = CornerRadius(20f, 20f)
        )
        drawContext.canvas.nativeCanvas.drawText("f", center.x + 25, center.y + 90, paint)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun FacebookPreview(){
    FacebookIcon()
}