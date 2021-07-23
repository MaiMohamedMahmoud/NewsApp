package com.codinginflow.mvvmnewsapp.data.newsorg

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticlesResponse>
)
