package com.example.mixmusic.viewmodel

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.mixmusic.R

data class SoundSlot(
    val name: String,
    val soundUri: Uri? = null,
    val resId: Int? = null,
    var player: MediaPlayer? = null
)

class MusicViewModel : ViewModel() {

    val fixedTracks = mutableListOf(
        SoundSlot("Tema 1", null, R.raw.stranger),
        SoundSlot("Tema 2", null, R.raw.uplifting)
    )

    val userTracks = mutableListOf<SoundSlot>()

    fun togglePlay(soundSlot: SoundSlot, context: Context) {
        if (soundSlot.player == null) {
            if (soundSlot.soundUri != null) {
                soundSlot.player = MediaPlayer.create(context, soundSlot.soundUri)
            } else if (soundSlot.resId != null) {
                soundSlot.player = MediaPlayer.create(context, soundSlot.resId)
            }
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
