package com.codinginflow.mvvmnewsapp.data.network

data class NewsArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsArticleDto>
)
