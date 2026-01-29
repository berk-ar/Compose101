package com.berkar.compose101

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.berkar.compose101.ui.theme.Compose101Theme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose101Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        MyTopBar()
                    }) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text(text = "TopBar") },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Pressed", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "Back Button",
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    )
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Column {
        Text(text = "Login Screen")
        Button(onClick = {
            navController.navigate(NavigationItem.Register.route)
        }) {
            Text(text = "Go to Register")
        }
    }

}

@Composable
fun RegisterScreen(navController: NavHostController) {
    Column {
        Text(text = "Register Screen")
        Button(onClick = {
            navController.navigate(NavigationItem.Login.route)
        }) {
            Text(text = "Go to Login")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Compose101Theme {

    }
}