package com.pixora.app.model

import android.net.Uri

enum class LayerType { PHOTO, TEXT, STICKER }

data class CanvasLayer(
    val id: String,
    val type: LayerType,
    val uri: Uri? = null,
    val text: String = "",
    val x: Float = 0f,
    val y: Float = 0f,
    val scale: Float = 1f,
    val rotation: Float = 0f
)

enum class AspectRatioType(val label: String, val ratio: Float) {
    SQUARE("1:1", 1f),
    PORTRAIT("4:5", 0.8f),
    STORY("9:16", 0.5625f),
    LANDSCAPE("16:9", 1.777f)
}

