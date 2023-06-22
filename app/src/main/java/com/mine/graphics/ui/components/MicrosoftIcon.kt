package com.mine.graphics.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MicrosoftIcon() {
    Canvas(modifier = Modifier.size(100.dp)) {
        val width = this.size.width
        val height = this.size.height

        val path = Path()
        path.moveTo(width / 2, height / 2)
        path.lineTo(width + 5, height * .05f)
        path.lineTo(width + 20, height * 0.45f)

        clipPath(path = path, clipOp = ClipOp.Difference) {
            drawCircle(
                color = Color.Transparent,
                radius = 100f,
                style = Stroke(40f, cap = StrokeCap.Round)
            )
            drawPath(path = path, color = Color.Transparent)
        }

        drawRect(
            color = Color(0xFFF25022),
            size = Size(width * .50f, height * .45f),
            topLeft = Offset(width * .0f, height * 0f)
        )
        drawRect(
            color = Color(0xFF7FBA00),
            size = Size(width * .50f, height * .45f),
            topLeft = Offset(width * .55f, height * 0f)
        )

        drawRect(
            color = Color(0xFFFFB900),
            size = Size(width * .50f, height * .45f),
            topLeft = Offset(width * .55f, height * .50f)
        )

        drawRect(
            color = Color(0xFF00A4EF),
            size = Size(width * .50f, height * .45f),
            topLeft = Offset(width * 0f, height * .50f)
        )
    }
}

@Composable
@Preview
fun MicrosoftPreview() {
    MicrosoftIcon()
}