package com.codinginflow.mvvmnewsapp.domain.model

import androidx.room.PrimaryKey
import com.codinginflow.mvvmnewsapp.data.localdb.ArticleEntity
import com.codinginflow.mvvmnewsapp.data.newsorg.ArticlesResponse

fun List<ArticlesResponse>.asDataBaseModel(): List<ArticleEntity> {
    return map { newsResponse ->
        ArticleEntity(
            title = newsResponse.title,
            url = newsResponse.url,
            thumbnailUrl = newsResponse.urlToImage,
            isBookmarked = false,
            isBreakNews = true
        )
    }
}

fun List<ArticleEntity>.asDomainModel(): List<Article> {
    return map { newsDao ->
        Article(
            title = newsDao.title,
            thumbnailUrl = newsDao.thumbnailUrl,
            isBookmarked = false,
            isBreakNews = true
        )
    }
}