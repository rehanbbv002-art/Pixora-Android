package com.pixora.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pixora.app.model.CanvasLayer
import com.pixora.app.model.LayerType

@Composable
fun CanvasViewCompose(
    layers: List<CanvasLayer>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        if (layers.isEmpty()) {
            Text("Canvas is Empty. Add a Photo or Text!", color = Color.White)
        } else {
            layers.forEach { layer ->
                when (layer.type) {
                    LayerType.PHOTO -> {
                        AsyncImage(
                            model = layer.uri,
                            contentDescription = "Layer Image",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    LayerType.TEXT -> {
                        Text(text = layer.text, color = Color.White, modifier = Modifier.padding(16.dp))
                    }
                    else -> {}
                }
            }
        }
    }
}

