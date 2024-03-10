

package com.example.bmiapp.Screens

import android.content.Intent
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen( navcontroller: NavHostController) {

    var HeightText by remember { mutableStateOf("") }

    var WeightText by remember { mutableStateOf("") }



    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)
        .padding(top = 10.dp),verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally){

        TitleText(text = "BMI CALCULATOR")


        Spacer(modifier = Modifier.padding( top = 75.dp))

        Row {

            TextField(

                colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Green,
                unfocusedIndicatorColor = Color.Black,
                containerColor = Black
                ,textColor = Green),value = HeightText, onValueChange = { HeightText = it }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),label = { Text("Boyunuzu giriniz", color = Color.White, fontSize = 20.sp)})


            TitleText(text = "CM")

        }
        Spacer(modifier = Modifier.padding( top = 75.dp))

        Row {
            TextField(colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Green,
                unfocusedIndicatorColor = Color.Black,
                containerColor = Black
                ,textColor = Green),value = WeightText, onValueChange = { WeightText = it }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),label = { Text("Kilonuzu giriniz",color = Color.White, fontSize = 20.sp)})
            TitleText(text = "KG")

        }
        Spacer(modifier = Modifier.padding( top = 55.dp))


        val current = LocalContext.current
        TextButton(onClick = {
            if (HeightText.isBlank() || WeightText.isBlank()) {
                Toast.makeText(current, "Lütfen boş alanları doldurunuz", Toast.LENGTH_SHORT).show()
            } else {
                navcontroller.navigate("result/$HeightText/$WeightText")
            }
        }, modifier = Modifier.padding(start = 20.dp)) {
            Text(text = "SONUÇ", fontSize = 30.sp, color = Color.White)
        }




    }



}








