package com.example.sendcolor.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sendcolor.model.ColorViewModel

@Composable
fun HexInputScreen(viewModel: ColorViewModel, navController: NavController) {
    var hex by remember { mutableStateOf("") }
    val loading by viewModel.loading.observeAsState(false)
    val colorDetails by viewModel.colorResponse.observeAsState()
    val error by viewModel.error.observeAsState()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = hex,
            onValueChange = { hex = it },
            label = { Text("Enter Hex Code") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        Button(
            onClick = { viewModel.fetchColorDetails(hex) },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Get Color Info")
        }

        if (loading) {
            CircularProgressIndicator()
        }

        error?.let {
            Text(text = it, color = Color.Red)
        }

        colorDetails?.let {
            LaunchedEffect(it) {
                navController.navigate("color_details")
            }
        }
    }
}



