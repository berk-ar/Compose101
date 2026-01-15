package com.berkar.compose101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.berkar.compose101.model.CryptoModel
import com.berkar.compose101.service.CryptoAPI
import com.berkar.compose101.ui.theme.Compose101Theme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCompose : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreenRetrofit()
        }
    }
}

@Composable
fun MainScreenRetrofit() {

    val BASE_URL = "https://raw.githubusercontent.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoAPI::class.java)

    val call = retrofit.getData()

    call.enqueue(object : Callback<List<CryptoModel>> {
        override fun onResponse(
            call: Call<List<CryptoModel>?>,
            response: Response<List<CryptoModel>?>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    it.forEach {
                        println(it.currency)
                    }
                }
            }
        }

        override fun onFailure(
            call: Call<List<CryptoModel>?>,
            t: Throwable
        ) {
            t.printStackTrace()
        }

    })

    Scaffold(topBar = { AppBar() }) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
        ) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(
                "Retrofit Compose"
            )
        }
    )
}

@Composable
fun CryptoList(cryptos: List<CryptoModel>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(cryptos) { crypto ->
            CryptoRow(crypto)
        }
    }
}

@Composable
fun CryptoRow(crypto: CryptoModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Text(
            text = crypto.currency,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = crypto.price,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Compose101Theme {
        CryptoRow(CryptoModel("BTC", "123123"))
    }
}