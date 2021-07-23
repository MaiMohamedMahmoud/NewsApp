package com.codinginflow.mvvmnewsapp.domain.model
import com.codinginflow.mvvmnewsapp.data.newsorg.ArticlesResponse

fun List<ArticlesResponse>.asDomainModel(): List<Article> {
    return map { newsResponse ->
        Article(
            title = newsResponse.title,
            thumbnailUrl = newsResponse.urlToImage,
            isBookmarked = false,
            isBreakNews = true
        )
    }
}