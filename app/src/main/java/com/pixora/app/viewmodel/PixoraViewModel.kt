package com.pixora.app.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.pixora.app.model.CanvasLayer
import com.pixora.app.model.LayerType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class PixoraViewModel : ViewModel() {
    private val _layers = MutableStateFlow<List<CanvasLayer>>(emptyList())
    val layers: StateFlow<List<CanvasLayer>> = _layers

    fun addPhotoLayer(uri: Uri) {
        val newLayer = CanvasLayer(
            id = UUID.randomUUID().toString(),
            type = LayerType.PHOTO,
            uri = uri
        )
        _layers.value = _layers.value + newLayer
    }

    fun addTextLayer(text: String) {
        val newLayer = CanvasLayer(
            id = UUID.randomUUID().toString(),
            type = LayerType.TEXT,
            text = text
        )
        _layers.value = _layers.value + newLayer
    }

    fun clearCanvas() {
        _layers.value = emptyList()
    }
}

