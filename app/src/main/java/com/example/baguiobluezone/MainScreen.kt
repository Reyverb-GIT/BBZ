package com.example.baguiobluezone

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.baguiobluezone.pages.FoodPage
import com.example.baguiobluezone.pages.HomePage
import com.example.baguiobluezone.news.NewsPage
import com.example.baguiobluezone.news.NewsViewModel

@Composable
fun MainScreen(newsViewModel: NewsViewModel) {


    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("News", Icons.Default.Star),
        NavItem("Food", Icons.Default.ShoppingCart)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index ,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector =navItem.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = Modifier
                .padding(innerPadding),
            selectedIndex,
            newsViewModel
        )
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int, newsViewModel: NewsViewModel) {
    when(selectedIndex){
        0 -> HomePage()
        1 -> NewsPage(newsViewModel)
        2 -> FoodPage()
    }
}