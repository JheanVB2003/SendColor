package com.example.sendcolor.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sendcolor.model.ColorViewModel



@Composable
fun ColorDetailsScreen(viewModel: ColorViewModel) {
    val colorDetails = viewModel.colorResponse.observeAsState() // Observe LiveData no ViewModel

    colorDetails.value?.let { color ->
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text("Color Name: ${color.name}")
            Text("Hex Code: ${color.hexCode}")
            Text("RGB Code: ${color.rgbCode}")
            Text("RYB Percentages: ${color.rybPercentages}")
            Text("Color Temperature: ${color.colorTemperature}")
            Text("Description: ${color.colorDescription}")
            Text("Two Hex Colors That Match: ${color.twoHexOfColorsThatMatch}")
            Text("Color Terminology: ${color.colorTerminology}")

        }
    } ?: run {
        Text("No color details available", modifier = Modifier.padding(16.dp))
    }
}


