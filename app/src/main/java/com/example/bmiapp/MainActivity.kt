package com.example.bmiapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.bmiapp.Navigation.NavigatonGraph
import com.example.bmiapp.ui.theme.BMIAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            window.statusBarColor = getColor(R.color.black)
            window.navigationBarColor = getColor(R.color.black)
            BMIAppTheme {
                NavigatonGraph()
            }
        }
    }
}

