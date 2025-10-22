package com.example.mixmusic.navigation
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {  },
        actions = {
            val context = LocalContext.current
            IconButton(onClick = {
                //Anadir intent
            }) {
                //Anadir icono
            }
            IconButton(onClick = {
                //Anadir intent

            }) {
                //Anadir icono
            }
            //Anadir los demás IconButton

        }
    )
}

//Anadir codigo para generar la estructura de la venta y poder navegar entre ventanas.

