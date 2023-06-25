package com.mine.graphics.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MozillaIcon (){
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Draw the outer circle
        drawCircle(
            color = Color(0XFFE66000),
            radius = 200f,
            center = center,
            style = Fill
        )

        // Draw the inner white circle
        drawCircle(
            color = Color.White,
            radius = 160f,
            center = center,
            style = Fill
        )

        // Draw the fox head shape
        val path = Path().apply {
            moveTo(center.x - 100f, center.y - 60f)
            arcTo(
                Rect(center.x - 100f, center.y - 100f, center.x + 100f, center.y + 100f),
                -45f,
                270f,
                false
            )
            lineTo(center.x - 100f, center.y - 60f)
            close()
            moveTo(center.x - 80f, center.y - 20f)
            lineTo(center.x + 50f, center.y - 20f)
            lineTo(center.x + 20f, center.y + 80f)
            lineTo(center.x - 80f, center.y + 80f)
            close()
        }
        drawPath(
            path = path,
            color = Color(0xFFFF9400),
            style = Fill
        )

        // Draw the globe shape
        val globeRadius = 60f
        drawCircle(
            color = Color.White,
            radius = globeRadius,
            center = Offset(center.x + 40f, center.y + 20f),
            style = Fill
        )
        drawCircle(
            color = Color(0xFFF9400),
            radius = globeRadius - 10f,
            center = Offset(center.x + 40f, center.y + 20f),
            style = Fill
        )

        // Draw the globe segments
        val segmentCount = 9
        val segmentAngle = 360f / segmentCount
        val segmentRadius = globeRadius - 20f
        val segmentStartAngle = 15f
        for (i in 0 until segmentCount) {
            val startAngle = i * segmentAngle + segmentStartAngle
            val endAngle = startAngle + segmentAngle
            drawArc(
                color = Color(0xFFFFFFFF),
                startAngle = startAngle,
                sweepAngle = segmentAngle - 8f,
                useCenter = true,
                topLeft = Offset(center.x + 40f - segmentRadius, center.y + 20f - segmentRadius),
                size = Size(segmentRadius * 2f, segmentRadius * 2f),
                style = Fill
            )
            drawArc(
                color = Color(0XFFFF9400),
                startAngle = startAngle + 8f,
                sweepAngle = segmentAngle - 16f,
                useCenter = true,
                topLeft = Offset(center.x + 40f - segmentRadius, center.y + 20f - segmentRadius),
                size = Size(segmentRadius * 2f, segmentRadius * 2f),
                style = Fill
            )
        }
    }


}
@Composable
@Preview
fun MozillaIconPreview() {
    MozillaIcon()
}