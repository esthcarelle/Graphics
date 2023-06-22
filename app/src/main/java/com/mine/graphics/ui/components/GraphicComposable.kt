package com.mine.graphics.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RectangleComposable() {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Canvas(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                change.consume()
                offsetX += dragAmount.x
                offsetY += dragAmount.y
            }
        }
    ) {
        val canvasQuadrantSize = size / 2F
        drawRect(
            topLeft = Offset(offsetX, offsetY),
            color = Color.Blue,
            size = canvasQuadrantSize
        )
    }
}

@Composable
fun DrawCircle() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        scale(scaleX = 5f, scaleY = 5f) {
            drawCircle(Color.Blue, radius = 20.dp.toPx())
        }
    }
}

@Composable
fun DrawLine() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Fetching width and height for
        // setting start x and end y
        val canvasWidth = size.width
        val canvasHeight = size.height

        // drawing a line between start(x,y) and end(x,y)
        drawLine(
            start = Offset(x = canvasWidth / 2, y = canvasHeight/2),
            end = Offset(x = canvasWidth / 2, y = canvasHeight),
            color = Color.Red,
            strokeWidth = 5F
        )

    }
}

@Preview
@Composable
fun Preview() {
    Surface {
        RectangleComposable()
        DrawCircle()
        DrawLine()
    }
}