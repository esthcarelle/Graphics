package com.mine.graphics.ui.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.res.ResourcesCompat
import com.mine.graphics.R

@Composable
fun BBCIcon() {
    Canvas(modifier = Modifier.fillMaxSize()) {

        val paint = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 100f
            color = Color.Red.toArgb()
        }

        val squareSize = 100f
        val spacing = 20f
        val startX = (size.width - (3 * squareSize + 2 * spacing)) / 2
        val startY = (size.height - squareSize) / 2

        // Draw the first white square

        drawRect(
            color = Color.White,
            topLeft = Offset(startX, startY),
            size = Size(squareSize, squareSize)
        )

        // Draw the second white square
        drawRect(
            color = Color.White,
            topLeft = Offset(startX + squareSize + spacing, startY),
            size = Size(squareSize, squareSize)
        )

        // Draw the third white square
        drawRect(
            color = Color.White,
            topLeft = Offset(startX + 2 * (squareSize + spacing), startY),
            size = Size(squareSize, squareSize)
        )
        drawContext.canvas.nativeCanvas.drawText("B", center.x, center.y + 40, paint)
        drawContext.canvas.nativeCanvas.drawText("B", 420f, center.y + 40, paint)
        drawContext.canvas.nativeCanvas.drawText("C", center.x + 120, center.y + 40, paint)
    }
}

@Composable
@Preview
fun BBCIconPreview() {
    BBCIcon()
}