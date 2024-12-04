package com.example.baguiobluezone.news

import kotlinx.serialization.Serializable

@Serializable
object NewsHomePageScreen


@Serializable
data class NewsArticleScreen(
    val url : String
)