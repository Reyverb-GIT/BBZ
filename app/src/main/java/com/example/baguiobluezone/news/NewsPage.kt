package com.example.baguiobluezone.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute


@Composable
fun NewsPage(newsViewModel: NewsViewModel, modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(text = "News",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Blue,
                fontSize = 25.sp
            )
            NavHost(navController = navController, startDestination = NewsHomePageScreen){
                composable<NewsHomePageScreen> {
                    NewsHomePage(newsViewModel,navController)
                }

                composable<NewsArticleScreen> {
                    val args = it.toRoute<NewsArticleScreen>()
                    NewsArticlePage(args.url)
                }

            }


        }
    }
}

