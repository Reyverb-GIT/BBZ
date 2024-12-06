package com.example.baguiobluezone.foodhub.recipe.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baguiobluezone.foodhub.recipe.data.model.Meal
import com.example.baguiobluezone.ui.theme.Blue

@Composable
fun SuccessComponent(recipes: List<Meal>, onSearchClicked: (query: String) -> Unit) {
    Column (
        modifier = Modifier
            .statusBarsPadding()
    ) {
        Text(
            text = "Food Hub",
            fontWeight = FontWeight(900),
            fontSize = 32.sp,
            color = Blue

        )
        SearchComponent(onSearchClicked = onSearchClicked)
        RecipesList(recipes = recipes)
    }
}