package com.example.projecto1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.jetbrains.annotations.Async
import coil.compose.AsyncImage

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LoginForm(navController)
    }
}
@Composable
fun LoginForm(navController: NavController){
    var user by remember { mutableStateOf("")  }
    var password by remember { mutableStateOf("")  }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(40.dp,0.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            AsyncImage(
                model  = "https://clipartcraft.com/images/transparent-logo-vector-8.png",
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxSize(),
                value = user,
                maxLines = 1,
                onValueChange = {user = it},
                label = {Text(text = "User")}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxSize(),
                value = password,
                maxLines = 1,
                onValueChange = {password = it},
                label = {Text(text = "Password")}
            )
            FilledTonalButton(
                modifier = Modifier.padding(0.dp,10.dp)
                    .padding(0.dp,10.dp),
                onClick = {},
            ) {
                Text(text = "Register")
            }
            OutlinedButton (
                modifier = Modifier
                    .padding(0.dp,10.dp)
                    .padding(0.dp,10.dp),
                onClick = {}
            ) {
                Text( text = "Forgot Password")
            }


        }

    }
}