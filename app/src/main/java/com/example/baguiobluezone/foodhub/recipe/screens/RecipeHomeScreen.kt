package com.example.baguiobluezone.foodhub.recipe.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.baguiobluezone.foodhub.recipe.components.ErrorComponent
import com.example.baguiobluezone.foodhub.recipe.components.LoadingComponent
import com.example.baguiobluezone.foodhub.recipe.components.SuccessComponent
import com.example.baguiobluezone.foodhub.recipe.viewmodel.RecipeViewIntent
import com.example.baguiobluezone.foodhub.recipe.viewmodel.RecipeViewModel
import com.example.baguiobluezone.foodhub.recipe.viewmodel.RecipeViewState

@Composable
fun FoodPage(recipeViewModel: RecipeViewModel) {
    val state by recipeViewModel.state

    when(state) {
        is RecipeViewState.Loading -> LoadingComponent()
        is RecipeViewState.Success -> {
            val recipes = (state as RecipeViewState.Success).recipes
            SuccessComponent(recipes = recipes, onSearchClicked = {query ->
                recipeViewModel.processIntent(RecipeViewIntent.SearchRecipes(query))
            })
        }
        is RecipeViewState.Error -> {
            val message = (state as RecipeViewState.Error).message
            ErrorComponent(message = message, onRefreshClicked = {
                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            })
        }
    }

    LaunchedEffect(Unit) {
        recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }
}