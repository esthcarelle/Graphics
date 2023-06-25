package com.mine.graphics.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OlympicIcon() {
    Canvas(modifier = Modifier.fillMaxSize()){
        drawCircle(color = Color.Blue, radius = 100f, center = Offset(150f, 200f), style = Stroke(width = 15f))
        drawCircle(color = Color.Black, radius = 100f, center = Offset(380f, 200f), style = Stroke(width = 15f))
        drawCircle(color = Color.Red, radius = 100f, center = Offset(610f, 200f), style = Stroke(width = 15f))
        drawCircle(color = Color.Yellow, radius = 100f, center = Offset(265f, 300f), style = Stroke(width = 15f))
        drawCircle(color = Color.Green, radius = 100f, center = Offset(500f, 300f), style = Stroke(width = 15f))

    }
}
@Composable
@Preview
fun OlympicsPreview(){
    Surface() {
        OlympicIcon()
    }
}