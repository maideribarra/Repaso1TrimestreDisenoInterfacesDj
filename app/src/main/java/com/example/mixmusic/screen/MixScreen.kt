package com.example.mixmusic.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mixmusic.viewmodel.MusicViewModel
import com.example.mixmusic.viewmodel.SoundSlot

@Composable
fun MixScreen(viewModel: MusicViewModel, context: Context = LocalContext.current) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color(0xFFEDEDED))) {

        Text(
            "Music Mix",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF4A148C)
        )
        Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color(0xFF4A148C), thickness = 2.dp)


        Spacer(Modifier.height(16.dp))

        // Sección de canciones fijas
        Text("Muestras", style = MaterialTheme.typography.titleMedium, color = Color(0xFF4A148C))
        Spacer(Modifier.height(4.dp))
        for (track in viewModel.fixedTracks) {
            SongCard(track, viewModel, context)
        }

        Spacer(Modifier.height(16.dp))

        // Sección de canciones del móvil
        Text("Canciones importadas", style = MaterialTheme.typography.titleMedium, color = Color(0xFF4A148C))
        Spacer(Modifier.height(4.dp))
        for (track in viewModel.userTracks) {
            SongCard(track, viewModel, context)
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { viewModel.stopAll() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.PlayArrow, contentDescription = "Stop")
            Spacer(Modifier.width(8.dp))
            Text("Detener todo", color = Color.White)
        }
    }
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(soundSlot.name, color = Color(0xFF4A148C))
            Button(
                onClick = { viewModel.togglePlay(soundSlot, context) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7B1FA2))
            ) {
                Text(if (soundSlot.player?.isPlaying == true) "⏸️ Pausa" else "▶️ Play", color = Color.White)
            }
        }
    }
}
