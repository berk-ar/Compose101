package com.berkar.compose101

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun MainScreenStateManagement() {

    Surface(color = Color.LightGray) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var myString by remember { mutableStateOf("Hello Compose") }

            TextField(value = myString, onValueChange = {
                myString = it
                println(myString)
            })

            Spacer(modifier = Modifier.padding(5.dp))

            var myAndroid by remember { mutableStateOf("Hello Android") }
            Text(
                text = myAndroid
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Button(onClick = {
                myAndroid = "Hello Compose"
                println(myAndroid)
            }) {
                Text(text = "Button")
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.kotlin),
                contentDescription = null
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        }
    }
}