package com.berkar.compose101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.berkar.compose101.ui.theme.Compose101Theme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose101Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Button(onClick = {
        navController.navigate(NavigationItem.Register.route)
    }) {
        Text(text = "Kayıt Ol Sayfasına Git")
    }
}

@Composable
fun RegisterScreen(navController: NavHostController) {
    Button(onClick = {
        navController.navigate(NavigationItem.Login.route)
    }) {
        Text(text = "Giriş Sayfasına Git")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Compose101Theme {

    }
}