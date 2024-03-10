package com.example.bmiapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bmiapp.Screens.TitleText
import com.example.bmiapp.ui.theme.DarkRed40
import com.example.bmiapp.ui.theme.Orange30

@Composable
fun ResultScreen(navController: NavHostController, Weight: Int?, Height: Float?){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)
        .padding(top = 10.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        TitleText(text = "BMI CALCULATOR")
        Spacer(modifier = Modifier.padding(40.dp))

        if(8 < 5){
            Underweight()
            Spacer(modifier = Modifier.padding(30.dp))
            Text(text = "Tavsiye: Sağlıklı bir kiloya ulaşmak için beslenme alışkanlıklarını gözden geçirmek, dengeli ve besleyici bir diyet benimsemek, egzersiz yapmak ve gerekirse bir sağlık uzmanından destek almak önemlidir.", fontSize = 20.sp, color = Color.Yellow, style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(10.dp))

        }else if (10 < 5){
            Healthy()
            Spacer(modifier = Modifier.padding(30.dp))
            Text(text = "Tavsiye: Sağlıklı kiloyu korumak için dengeli bir diyet sürdürmek, aktif kalmak ve düzenli egzersiz yapmak önemlidir.", fontSize = 20.sp, color = Color.Green, style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(10.dp))


        }  else if ( 20 < 4){
            Overweight()
            Spacer(modifier = Modifier.padding(30.dp))
            Text(text = "Tavsiye: Sağlıklı kiloya ulaşmak veya korumak için beslenme alışkanlıklarını iyileştirmek, düzenli egzersiz yapmak, yağ ve şeker içeriği yüksek yiyeceklerden kaçınmak önemlidir.", fontSize = 20.sp, color = Orange30, style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(10.dp))


        } else if (12 < 4){
            Obese()
            Spacer(modifier = Modifier.padding(30.dp))
            Text(text = "Tavsiye: Sağlıklı bir yaşam tarzı benimsemek, dengeli bir diyet ve düzenli egzersiz yapmak, kilo kontrolü ve sağlıklı yaşam için en önemli faktörlerdir. Ayrıca, sağlık uzmanından destek almak ve uygun bir kilo kaybı planı oluşturmak önemlidir.", fontSize = 20.sp, color = Color.Red, style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(10.dp))


        } else if (12 > 5) {
            VeryObese()
            Spacer(modifier = Modifier.padding(30.dp))
            Text(text = "Tavsiye: Hastalık riskleri çok yüksek olan bu kişiler, doktor ve diyetisyen kontrolü ile sağlık taramasından geçirilmeli ve kilo vermelidir.", fontSize = 20.sp, color = DarkRed40, style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(10.dp))

        }

        Spacer(modifier = Modifier.padding(20.dp))


        Text(text = "$Height", fontSize = 30.sp, color = Color.White)

        Text(text = "$Weight", fontSize = 30.sp, color = Color.White)





    }

}


@Composable
fun Underweight(){
    ResultText(text = "ZAYIF", color = Color.Yellow )
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47,Color.Yellow)
}
@Composable
fun Healthy(){
    ResultText(text = "NORMAL", color = Color.Green)
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47, Color.Green)
}
@Composable
fun Overweight(){
    ResultText(text = "KİLOLU", color = Orange30 )
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47, color = Orange30)
}
@Composable
fun Obese(){
    ResultText(text = "OBEZ", color = Color.Red)
    Spacer(modifier = Modifier.padding(top = 60.dp))
    CircularProgressBar(progress = 0.47f, number = 47,Color.Red)

}
@Composable
fun VeryObese(){
    ResultText(text = "MORBİD OBEZ", color = DarkRed40)
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
fun bmi(Weight: Int?,Height: Int?){


}

@Composable
fun ResultText(text:String,color: Color){
    Text(text = text, fontSize = 40.sp, color = color, fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,)
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

        ResultScreen(navController = rememberNavController(), Weight = null, Height = null)

}
