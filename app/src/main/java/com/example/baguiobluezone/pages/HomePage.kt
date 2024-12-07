package com.example.baguiobluezone.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.baguiobluezone.R
import com.example.baguiobluezone.ui.theme.White

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .verticalScroll(scrollState), // Enable vertical scrolling
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Add Image
        Image(
            painter = painterResource(id = R.drawable.homepage_new),
            contentDescription = "Home Image"
        )

        // Add Text below the Image
        Text(text = "Home Page")
    }
}
