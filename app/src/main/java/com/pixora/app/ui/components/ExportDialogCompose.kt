package com.pixora.app.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ExportDialogCompose(
    onDismiss: () -> Unit,
    onConfirmExport: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Export Image") },
        text = { Text("Do you want to save this image to your gallery?") },
        confirmButton = {
            TextButton(onClick = onConfirmExport) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

