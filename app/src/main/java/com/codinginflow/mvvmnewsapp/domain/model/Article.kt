package com.codinginflow.mvvmnewsapp.domain.model

data class Article(
    val title: String?,
    val thumbnailUrl: String?,
    val isBookmarked: Boolean,
    val isBreakNews: Boolean,
    val updatedAt: Long = System.currentTimeMillis()
)