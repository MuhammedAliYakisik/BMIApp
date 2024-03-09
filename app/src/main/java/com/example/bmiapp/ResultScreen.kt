package com.example.bmiapp

import android.health.connect.datatypes.units.Percentage
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bmiapp.Screens.DetailScreen
import com.example.bmiapp.Screens.TitleText
import com.example.bmiapp.ui.theme.DarkRed40
import com.example.bmiapp.ui.theme.Orange30

@Composable
fun ResultScreen(navcontroller: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)
        .padding(top = 10.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        TitleText(text = "BMI CALCULATOR")
        Spacer(modifier = Modifier.padding(40.dp))

        if(8 < 5){
            Underweight()

        }else if (10 < 5){
            Healthy()

        }  else if ( 20 <4){
            Overweight()

        } else if (12 < 4){
            Obese()

        } else if (12 > 5) {
            VeryObese()
        }

        Spacer(modifier = Modifier.padding(20.dp))


    }

}



@Composable
fun Healthy(){
    ResultText(text = "HEALTHY", color = Color.Green)
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47, Color.Green)

}
@Composable
fun Underweight(){
    ResultText(text = "UNDERWEİGHT", color = Color.Yellow )
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47,Color.Yellow)

}
@Composable
fun Overweight(){
    ResultText(text = "OVERWEİGHT", color = Orange30 )
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47, color = Orange30)
}
@Composable
fun Obese(){
    ResultText(text = "OBESE", color = Color.Red)
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47,Color.Red)

}
@Composable
fun VeryObese(){
    ResultText(text = "VERY OBESE", color = DarkRed40)
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47, color = DarkRed40)

}

@Composable
fun CircularProgressBar(progress: Float, number: Int,color: Color, modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(100.dp)) {
        val innerRadius = size.minDimension / 2 - 8
        val outerRadius = size.minDimension / 2
        val center = Offset(size.width / 2, size.height / 2)

        drawArc(
            color = Color.Black,
            startAngle = -90f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round),
            topLeft = Offset(center.x - outerRadius, center.y - outerRadius),
            size = Size(outerRadius * 2, outerRadius * 2)
        )

        drawArc(
            color = color,
            startAngle = -90f,
            sweepAngle = 360 * progress,
            useCenter = false,
            style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round),
            topLeft = Offset(center.x - outerRadius, center.y - outerRadius),
            size = Size(outerRadius * 2, outerRadius * 2)
        )

        // Draw number inside the circular progress bar
        drawIntoCanvas {
            val paint = Paint().asFrameworkPaint()
            paint.textSize = 24.sp.toPx()
            paint.color = Color.White.toArgb()
            paint.textAlign = android.graphics.Paint.Align.CENTER
            val xPos = size.width / 2
            val yPos = (size.height / 2 - (paint.descent() + paint.ascent()) / 2)
            it.nativeCanvas.drawText(number.toString(), xPos, yPos, paint)
        }
    }
}







@Composable
fun ResultText(text:String,color: Color){
    Text(text = text, fontSize = 40.sp, color = color, fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ResultScreen(navcontroller = rememberNavController())
}