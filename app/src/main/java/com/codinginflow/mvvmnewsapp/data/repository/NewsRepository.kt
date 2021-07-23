package com.codinginflow.mvvmnewsapp.data.repository

import com.codinginflow.mvvmnewsapp.data.newsorg.NewsApi
import com.codinginflow.mvvmnewsapp.domain.model.Article
import com.codinginflow.mvvmnewsapp.domain.model.asDomainModel
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    suspend fun getBreakingNews(): List<Article> {
        val response = newsApi.getBreakingNews("us", 100)
        val serverArticles = response.articles
        return serverArticles.asDomainModel()
    }

    suspend fun searchNews(query: String) {
        newsApi.searchNews(query, 1, 100)
    }


}