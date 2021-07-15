package com.codinginflow.mvvmnewsapp.data.repository

import com.codinginflow.mvvmnewsapp.data.network.NewsApi
import com.codinginflow.mvvmnewsapp.data.network.NewsArticleDto
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    suspend fun getBreakingNews(): List<NewsArticleDto> {
        val response = newsApi.getBreakingNews("us", 100)
        return response.articles
    }

    suspend fun searchNews(query: String) {
        newsApi.searchNews(query, 1, 100)
    }


}