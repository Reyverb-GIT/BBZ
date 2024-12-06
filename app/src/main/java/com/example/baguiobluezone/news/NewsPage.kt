package com.example.baguiobluezone.news

import android.content.ClipData.Item
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.baguiobluezone.ui.theme.Blue


@Composable
fun NewsPage(newsViewModel: NewsViewModel, paddingValues: PaddingValues) {

    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(text = "News",
                modifier = Modifier,
                color = Blue,
                fontSize = 25.sp
            )
            NavHost(navController = navController, startDestination = NewsHomePageScreen){
                composable<NewsHomePageScreen> {
                    NewsHomePage(newsViewModel,navController, innerPadding)
                }

                composable<NewsArticleScreen> {
                    val args = it.toRoute<NewsArticleScreen>()
                    NewsArticlePage(args.url)
                }
            }


        }
    }
}

