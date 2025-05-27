package com.example.sendcolor.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
            color.rgb?.let { rgb ->
                Text("RGB: R=${rgb.red}, G=${rgb.green}, B=${rgb.blue}")
            } ?: Text("RGB: não disponível")
            Text("HSL Code: ${color.hsl}")
            Text("Luminance: ${color.luminance}")
            Text("Accessible on WHITE: ${if (color.accessibleOnWhite) "Yes" else "No"}")
            Text("Accessible on BLACK: ${if (color.accessibleOnBlack) "Yes" else "No"}")

            Spacer(modifier = Modifier.height(8.dp))
            Text("Description: ${color.description}")

            Spacer(modifier = Modifier.height(8.dp))
            Text("Psychology Tags:")
            color.psychologyTags.forEach { tag ->
                Text("• $tag")
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Color Palette:")
            color.colorPalette.forEach { item ->
                Text("• ${item.name} (${item.hex})")
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Complementary Color: ${color.complementaryColor}")

            Spacer(modifier = Modifier.height(8.dp))
            Text("Hex Variations:")
            color.hexVariations.forEach { variation ->
                Text("• $variation")
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Color Category: ${color.colorCategory}")

            Spacer(modifier = Modifier.height(8.dp))
            Text("Design Usage Suggestions:")
            color.designUsageSuggestions.forEach { suggestion ->
                Text("• $suggestion")
            }

        }
    } ?: run {
        Text("No color details available", modifier = Modifier.padding(16.dp))
    }
}


