package com.example.compose.presentation

import android.graphics.Paint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose.ui.theme.PohangAshBrown
import com.example.compose.ui.theme.PohangYellow

@Composable
fun SurveyScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SurveyButton()
        SemiCircleProgressBar(0.0f)
    }
}


@Composable
fun SurveyButton() {
    Button(
        onClick = {
            //val randomNum = Math.random().toFloat() * 100
        },
        colors = ButtonDefaults
            .buttonColors(
                PohangYellow,
                contentColor = Color.White
            ),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
    ) {
        Text(text = "설문조사 하기")

    }
}

@Composable
fun SemiCircleProgressBar(randomValue: Float) {
    val animatedValue = remember { Animatable(0f) }
    var percent: Float = randomValue

    LaunchedEffect(animatedValue) {
        animatedValue.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
        )
        percent = randomValue * animatedValue.value
    }

    val scoreTextPaint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 50f
        color = PohangAshBrown.hashCode()
    }

    Column {
        Box(
            modifier = Modifier.size(400.dp, 200.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .size(400.dp)
                    .padding(16.dp)
            ) {
                drawArc(
                    color = Color.LightGray,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = false,
                    size = Size(900.dp.value, 900.dp.value),
                    style = Stroke(width = 40f, cap = StrokeCap.Round)
                )

                drawArc(
                    color = Color.Green,
                    startAngle = 180f,
                    sweepAngle = percent,
                    useCenter = false,
                    size = Size(900.dp.value, 900.dp.value),
                    style = Stroke(width = 40f, cap = StrokeCap.Round)
                )

                drawContext.canvas.nativeCanvas.drawText(
                    percent.toString(),
                    center.x,
                    200f,
                    scoreTextPaint
                )
            }
        }
    }
}