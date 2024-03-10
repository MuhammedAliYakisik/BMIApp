package com.example.bmiapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bmiapp.R


@Composable
fun HomeScreen(navcontroller: NavHostController) {
    Column (modifier = Modifier
        .background(Color.Black)
        .padding(top = 10.dp)
        .fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {

        TitleText(text = "BMI CALCULATOR")

        İmage()

        Spacer(modifier = Modifier.padding(10.dp))


        Row (){
            TextButton(onClick = { navcontroller.navigate(route = "detail")}) {
                Text(text = "ERKEK", fontSize = 30.sp, color = Color.White )

            }
            Spacer(modifier = Modifier.padding(20.dp))

            TextButton(onClick = { navcontroller.navigate("detail")  }, modifier = Modifier.padding(start = 20.dp)) {
                Text(text = "KADIN", fontSize = 30.sp, color = Color.White )

            }
        }

    }


}

@Composable
fun TitleText(text:String){
    Text(text = text, fontSize = 30.sp, color = Color.Green, fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,)
}
@Composable
fun İmage(){
    Row(modifier = Modifier
        .padding(top = 200.dp),
        verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.man),
            contentDescription = "man pic",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
        )



        Image(painter = painterResource(id = R.drawable.woman),
            contentDescription = "woman", contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .clip(
                    CircleShape
                ))



    }


}



