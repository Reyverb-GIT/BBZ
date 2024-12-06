package com.example.baguiobluezone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.baguiobluezone.foodhub.recipe.viewmodel.RecipeViewModel
import com.example.baguiobluezone.news.NewsViewModel
import com.example.baguiobluezone.ui.theme.BaguioBlueZoneTheme

class MainActivity : ComponentActivity() {
    private val recipeViewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        enableEdgeToEdge()

        val newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        setContent {
            BaguioBlueZoneTheme {
                MainScreen(newsViewModel,recipeViewModel)
            }
        }
    }
}

