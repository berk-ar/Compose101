package com.berkar.compose101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class StateManagementCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenState()
        }
    }
}

@Composable
fun MainScreenState() {

    var myString by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpecialText("Kotlin")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialText("Compose")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialTextField(myString) {
                myString = it
                println(myString)
            }
        }
    }
}

@Composable
fun SpecialText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun SpecialTextField(str: String, function: (String) -> Unit) {
    TextField(value = str, onValueChange = function)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MainScreenState()
}