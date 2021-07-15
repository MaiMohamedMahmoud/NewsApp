package com.codinginflow.mvvmnewsapp.data.localdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news_articles")
data class NewsArticleEntity(
    val title: String?,
    @PrimaryKey val url: String,
    val thumbnailUrl: String?,
    val isBookmarked: Boolean,
    val isBreakNews:Boolean,
    val updatedAt: Long = System.currentTimeMillis()
)