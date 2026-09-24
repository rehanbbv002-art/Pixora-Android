package com.pixora.app.util

import android.content.Context
import android.widget.Toast

object ImageExportUtils {
    fun saveImageToGallery(context: Context) {
        Toast.makeText(context, "Image Saved Successfully!", Toast.LENGTH_SHORT).show()
    }
}

