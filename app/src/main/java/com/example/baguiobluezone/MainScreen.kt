package com.example.baguiobluezone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.baguiobluezone.foodhub.recipe.viewmodel.RecipeViewModel
import com.example.baguiobluezone.foodhub.recipe.screens.FoodPage
import com.example.baguiobluezone.pages.HomePage
import com.example.baguiobluezone.news.NewsPage
import com.example.baguiobluezone.news.NewsViewModel
import com.example.baguiobluezone.pages.UserPage
import com.example.baguiobluezone.ui.theme.Blue
import com.example.baguiobluezone.ui.theme.White
import com.rahad.riobottomnavigation.composables.RioBottomNavItemData
import com.rahad.riobottomnavigation.composables.RioBottomNavigation

@Composable
fun MainScreen(newsViewModel: NewsViewModel, recipeViewModel: RecipeViewModel) {
    val items = listOf(
        R.drawable.home_default,
        R.drawable.explore_default,
        R.drawable.food_hub_default,
        R.drawable.user_profile_default,
    )

    val labels = listOf(
        " ",
        " ",
        " ",
        " "
    )

    // Use rememberSaveable to retain state across configuration changes
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    // Create RioBottomNavItemData for the bottom navigation buttons
    val buttons = items.mapIndexed { index, iconData ->
        RioBottomNavItemData(
            imageVector = ImageVector.vectorResource(iconData),
            selected = index == selectedIndex,
            onClick = { selectedIndex = index },  // Correct way to update state
            label = labels[index]
        )
    }

    // Main Scaffold setup
    Scaffold(
        bottomBar = {
            BottomNavigationBar(buttons = buttons)
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        // Handle the screen content based on the selected index
        ContentScreen(
            selectedIndex = selectedIndex,
            paddingValues = paddingValues,
            newsViewModel = newsViewModel,
            recipeViewModel = recipeViewModel
        )
    }
}

@Composable
fun ContentScreen(selectedIndex: Int, paddingValues: PaddingValues, newsViewModel: NewsViewModel,recipeViewModel: RecipeViewModel) {
    when (selectedIndex) {
        0 -> HomePage()
        1 -> NewsPage(newsViewModel,paddingValues)
        2 -> FoodPage(recipeViewModel)
        3 -> UserPage()
    }
}

@Composable
fun ShowText(x0: String) {
    Text(text = x0, modifier = Modifier.padding(16.dp))
}

@Composable
fun BottomNavigationBar(buttons: List<RioBottomNavItemData>) {
        Box(
            modifier = Modifier
                .offset(y = (70).dp)
                .fillMaxWidth()
                .height(50.dp)  // Same height as the nav bar
                .background(color = White, shape = RectangleShape) // Rectangle shape with desired color
        )

        // RioBottomNavigation on top of the rectangle
        Box(modifier = Modifier.offset(y = (-25).dp)) {
            RioBottomNavigation(
                fabIcon = ImageVector.vectorResource(id = R.drawable.qr_default),
                buttons = buttons,
                fabSize = 80.dp,
                barHeight = 70.dp,
                selectedItemColor = Blue,
                fabBackgroundColor = Blue,
                backgroundColor = White,
                cardElevation = 0.dp,

            )
        }
    }



