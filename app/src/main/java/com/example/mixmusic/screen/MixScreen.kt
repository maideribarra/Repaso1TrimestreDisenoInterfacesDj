package com.example.mixmusic.screen

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mixmusic.viewmodel.MusicViewModel
import com.example.mixmusic.viewmodel.SoundSlot

@Composable
fun MixScreen( context: Context = LocalContext.current) {

        // Seccion de canciones fijas
        //Anadir canciones fijas( las que alamacenamos en resources. En este caso como estamos trabajando con
        //imagenes se tienen que almacenar dentro de la carpeta raw




        // Sección de canciones del móvil
        //Aqui deberan anadirse las canciones cargadas desde el movil en la otra pantalla


        //Aquí anadir un boton que pare todas las canciones



}

@Composable
fun SongCard(soundSlot: SoundSlot, viewModel: MusicViewModel, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD1C4E9))
    ) {
        //Anadir contenido de la tarjeta, cada cancion deberá ir en una tarjeta.
    }
}
