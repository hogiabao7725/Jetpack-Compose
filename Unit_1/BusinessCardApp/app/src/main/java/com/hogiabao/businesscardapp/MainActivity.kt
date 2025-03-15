package com.hogiabao.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hogiabao.businesscardapp.ui.theme.BusinessCardAppTheme
import com.hogiabao.businesscardapp.ui.theme.Green

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun ContactRow(text: String, icon: ImageVector) {
    Row (
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Green,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(3f)
        )
    }
}

@Composable
fun BusinessCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(R.drawable.android)
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = stringResource(R.string.my_name),
            color = Color.White,
            fontSize = 50.sp
        )
        Text(
            text = stringResource(R.string.my_title),
            color = Green,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.padding(bottom = 200.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF4F6C79)
        )
        ContactRow(
            text = stringResource(R.string.my_phone_number),
            icon = Icons.Rounded.Phone
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF4F6C79)
        )
        ContactRow(
            text = stringResource(R.string.twitter_handle),
            icon = Icons.Rounded.Share
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF4F6C79)
        )
        ContactRow(
            text = stringResource(R.string.my_email),
            icon = Icons.Rounded.Email
        )
    }

}

@Preview(showBackground = true, device = "id:pixel_9_pro")
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF073042)
        ) {
            BusinessCard()
        }
    }
}