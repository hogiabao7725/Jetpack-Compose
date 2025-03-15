package com.hogiabao.newprojectexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hogiabao.newprojectexample.ui.theme.NewProjectExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewProjectExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Ho Gia Bao",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        color = Color.Yellow, // Màu nền vàng
        shape = RoundedCornerShape(16.dp), // Bo góc 16dp
        border = BorderStroke(2.dp, Color.Black), // Viền đen 2dp
        shadowElevation = 8.dp // Đổ bóng 8dp
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    NewProjectExampleTheme {
        Greeting("Chi Huy")
    }
}