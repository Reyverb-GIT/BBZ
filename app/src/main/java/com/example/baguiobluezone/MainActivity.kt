package com.example.baguiobluezone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.baguiobluezone.news.NewsViewModel
import com.example.baguiobluezone.ui.theme.BaguioBlueZoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        setContent {
            BaguioBlueZoneTheme {
                MainScreen(newsViewModel)
            }
        }
    }
}

