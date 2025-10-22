package com.example.mixmusic.screen


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

@Composable
fun AddScreen() {
    //Recoge la uri de la cancion del movil
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            //Anadir codigo
        }
    }

    //Anadir codigo para dibujar el boton de agregar cancion y resto de ventana.

    }

