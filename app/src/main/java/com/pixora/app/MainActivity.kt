package com.pixora.app

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pixora.app.ui.components.CanvasViewCompose
import com.pixora.app.ui.components.ExportDialogCompose
import com.pixora.app.ui.components.PixoraBottomToolbar
import com.pixora.app.ui.theme.PixoraTheme
import com.pixora.app.util.ImageExportUtils
import com.pixora.app.viewmodel.PixoraViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixoraTheme {
                PixoraMainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PixoraMainScreen(viewModel: PixoraViewModel = viewModel()) {
    val layers by viewModel.layers.collectAsState()
    var showExportDialog by remember { mutableStateOf(false) }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { viewModel.addPhotoLayer(it) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pixora Photo Editor") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            PixoraBottomToolbar(
                onAddPhotoClick = { photoPickerLauncher.launch("image/*") },
                onAddTextClick = { viewModel.addTextLayer("Pixora Text") },
                onExportClick = { showExportDialog = true }
            )
        }
    ) { innerPadding ->
        CanvasViewCompose(
            layers = layers,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )

        if (showExportDialog) {
            ExportDialogCompose(
                onDismiss = { showExportDialog = false },
                onConfirmExport = {
                    showExportDialog = false
                }
            )
        }
    }
}
