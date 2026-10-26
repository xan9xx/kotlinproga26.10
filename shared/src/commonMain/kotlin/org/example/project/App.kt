package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlexDirection.Companion.Row
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import javafx.stage.Screen
import org.jetbrains.compose.resources.painterResource

import kotlinproject.shared.generated.resources.Res
import kotlinproject.shared.generated.resources.compose_multiplatform
import kotlin.math.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App() {
    val points = remember {mutableStateListOf<Offset>()}
    Canvas(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
        .onPointerEvent(
            eventType = PointerEventType.Press
        ){
            val point = it.changes.first().position
            points.add(point)
        }
    ) {
        val xMin: Double = -5.0
        val xMax: Double = 5.0
        val yMin: Double = -5.0
        val yMax: Double = 5.0
        for(point in points){
            drawCircle(
                color = Color.Red,
                radius = 5f,
                center = point
            )
        }
        for (i in 1 until this.size.width.toInt()){
            draw
        }
        drawAxis(this)
    }
}

fun drawAxis(drawScope: DrawScope){
    drawScope.drawLine(
        color = Color.Black,
        start = Offset(0f, drawScope.size.height/2),
        end = Offset(drawScope.size.width, drawScope.size.height/2),
    )
    drawScope.drawLine(
        color = Color.Black,
        start = Offset(drawScope.size.width/2, 0f),
        end = Offset(drawScope.size.width/2, drawScope.size.height),
    )
}

fun f(x: Double) = cos(x)
fun screenPointFunction(sizeInfo: SizeInfo,spX: Float): Offset {
    val dpX = ScreenPoint(spX, 0f).toCartesianPoint(sizeInfo).x
    val dpY = f(dpX)
    val spY = CartesianPoint(dpX, dpY).toScreenPoint(sizeInfo).y
    return ScreenPoint(spX, spY).toOffset()

}
