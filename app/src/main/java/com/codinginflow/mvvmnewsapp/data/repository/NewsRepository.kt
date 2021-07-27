package com.codinginflow.mvvmnewsapp.data.repository

import android.util.Log
import com.codinginflow.mvvmnewsapp.data.localdb.ArticleEntity
import com.codinginflow.mvvmnewsapp.data.localdb.NewsArticleDatabase
import com.codinginflow.mvvmnewsapp.data.localdb.NewsDao
import com.codinginflow.mvvmnewsapp.data.newsorg.NewsApi
import com.codinginflow.mvvmnewsapp.domain.model.Article
import com.codinginflow.mvvmnewsapp.domain.model.asDataBaseModel
import com.codinginflow.mvvmnewsapp.domain.model.asDomainModel
import com.codinginflow.mvvmnewsapp.utlis.Resource
import com.codinginflow.mvvmnewsapp.utlis.performGetOperation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDb: NewsArticleDatabase,
    private val newsApi: NewsApi
) {
    private val newsDao = newsDb.newsArticleDao()
    fun getBreakingNews(): Flow<Resource<List<Article>>> {
        Log.i("yarab", "inside repo")
        return performGetOperation(
            databaseQuery = {
                newsDao.getBreakingNews().map { it.asDomainModel() }
            },
            networkCall = {
                val response = newsApi.getBreakingNews("us", 100)
                response.articles.asDataBaseModel()
            },
            saveCallResult = { newsDao.insertBreakingNews(it) })
    }

    suspend fun searchNews(query: String) {
        newsApi.searchNews(query, 1, 100)
    }


}