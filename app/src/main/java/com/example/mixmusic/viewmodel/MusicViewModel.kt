package com.example.mixmusic.viewmodel

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.mixmusic.R

//Esta será la estructura utilizada para almacenar las rutas de lass canciones y sus nombres
//En el caso de las canciones cargadas desde el proyecto se utiliza resId y las cargadas desde el movil
//soundUri
data class SoundSlot(
    val name: String,
    val soundUri: Uri? = null,
    val resId: Int? = null,
    var player: MediaPlayer? = null
)

//En esta clase no hace falta anadir nada mas que el condicional y cambiar los resId
class MusicViewModel : ViewModel() {

    //cambiar resId por la ruta interna del proyecto de dichos archivos
    val fixedTracks = mutableListOf(
        SoundSlot("Tema 1", null, 0),
        SoundSlot("Tema 2", null, 0)
    )

    val userTracks = mutableListOf<SoundSlot>()

    fun togglePlay(soundSlot: SoundSlot, context: Context) {

        if (soundSlot.player == null) {
            //Aqui hay que hacer un condicional si el soundUri es diferente a nulo
            //soundSlot.player = MediaPlayer.create(context, soundSlot.soundUri)
            // si no:
            //soundSlot.player = MediaPlayer.create(context, soundSlot.resId)
        }

        if (soundSlot.player == null) return

        if (soundSlot.player!!.isPlaying) {
            soundSlot.player!!.pause()
        } else {
            soundSlot.player!!.start()
        }
    }

    fun addUserTrack(uri: Uri, name: String = "Canción del móvil") {
        val newSlot = SoundSlot(name, soundUri = uri)
        userTracks.add(newSlot)
    }

    fun stopAll() {
        val allTracks = fixedTracks + userTracks
        for (track in allTracks) {
            track.player?.stop()
            track.player?.release()
            track.player = null
        }
    }
}
