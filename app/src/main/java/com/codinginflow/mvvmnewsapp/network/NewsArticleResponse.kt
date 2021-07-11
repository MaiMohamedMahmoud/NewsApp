package com.codinginflow.mvvmnewsapp.network

data class NewsArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsArticle>
)
