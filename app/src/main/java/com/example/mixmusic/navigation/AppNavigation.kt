package com.example.mixmusic.navigation



import androidx.compose.runtime.Composable

import android.content.Intent
import android.net.Uri

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mixmusic.screen.AddScreen
import com.example.mixmusic.screen.MixScreen
import com.example.mixmusic.viewmodel.MusicViewModel


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current


    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            val musicViewModel = MusicViewModel()
            composable("home") { MixScreen(musicViewModel,context) }
            composable("add") { AddScreen(musicViewModel) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("Dj") },
        actions = {
            val context = LocalContext.current
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/tuusuario"))
                context.startActivity(intent)
            }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "GitHub")
            }
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:tuemail@example.com")
                    putExtra(Intent.EXTRA_SUBJECT, "Feedback Flappy Simple")
                }
                context.startActivity(intent)
            }) {
                Icon(Icons.Default.MailOutline, contentDescription = "Email")
            }
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "¡Mira este juego que hice!")
                }
                context.startActivity(Intent.createChooser(intent, "Compartir"))
            }) {
                Icon(Icons.Default.Share, contentDescription = "Compartir")
            }
        }
    )
}

@Composable
fun BottomBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected = navController.currentBackStackEntry?.destination?.route == "home",
            onClick = { navController.navigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = navController.currentBackStackEntry?.destination?.route == "settings",
            onClick = { navController.navigate("add") },
            icon = { Icon(Icons.Default.Build, contentDescription = "Settings") },
            label = { Text("Add") }
        )
    }
}
