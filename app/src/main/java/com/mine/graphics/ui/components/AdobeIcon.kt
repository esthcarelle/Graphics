package com.mine.graphics.ui.components

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AdobeIcon() {
    Canvas(modifier = Modifier.size(100.dp)){
        val width = this.size.width
        val height = this.size.height

        val path = Path().apply {
            moveTo(size.width * .43f, size.height * .100f)
            lineTo(size.width * .90f, size.height * .95f)
            lineTo(size.width * .63f, size.height * .99f)
            close()
        }

        val paint = Paint().apply {
            color = Color.Black
            strokeWidth = 10f
            style = PaintingStyle.Fill
        }

        val a = Point(90, 90)
        val b = Point(0,100)
        val c = Point(87,50)

        val pathTriangle = Path().apply {
            fillType =  PathFillType.EvenOdd
            lineTo(b.x.toFloat(), b.y.toFloat())
            lineTo(c.x.toFloat(), c.y.toFloat())
            lineTo(a.x.toFloat(), a.y.toFloat())
            close()
        }

        drawPath(color = Color.White, path = pathTriangle)
        drawRect(
            color = Color(0xFF4384f3),
            size = Size(width * .56f, 20f),
            topLeft = Offset(width * .55f, height * .45f)
        )

        drawRect(
            color = Color(0xFF4384f3),
            size = Size(width * .30f, 20f),
            topLeft = Offset(width * .55f, height * .95f)
        )
    }
}
@Preview
@Composable
fun AdobeIconPreview(){
    AdobeIcon()
}