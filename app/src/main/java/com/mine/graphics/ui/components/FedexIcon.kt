package com.mine.graphics.ui.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FedexIcon(){
    Canvas(modifier = Modifier.size(100.dp)) {
        val paintF = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 120f
            color = Color(0xFFFF6600).toArgb()
            isFakeBoldText = true
        }

        val paintE = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 115f
            color = Color(0xFF4D148C).toArgb()
            isFakeBoldText = true
        }

        val paintX = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 90f
            color = Color(0xFFFF6600).toArgb()
            isFakeBoldText = true
        }
        val paintEe = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 100f
            color = Color(0xFF4D148C).toArgb()
            isFakeBoldText = true
        }

        //Add texts
        drawContext.canvas.nativeCanvas.drawText("F", 25f, center.y + 40, paintE)
        drawContext.canvas.nativeCanvas.drawText("e", 69f, center.y + 40, paintEe)
        drawContext.canvas.nativeCanvas.drawText("d", 120f, center.y + 40, paintE)
        drawContext.canvas.nativeCanvas.drawText("E", 172f, center.y + 40, paintF)
        drawContext.canvas.nativeCanvas.drawText("x", 230f, center.y + 40, paintX)
    }
}

@Preview
@Composable
fun FedexIconPreview(){
    Surface (modifier = Modifier.size(100.dp)){
        FedexIcon()
    }
}