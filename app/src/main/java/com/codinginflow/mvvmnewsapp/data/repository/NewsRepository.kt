package com.codinginflow.mvvmnewsapp.data.repository

import com.codinginflow.mvvmnewsapp.data.localdb.ArticleEntity
import com.codinginflow.mvvmnewsapp.data.localdb.NewsDao
import com.codinginflow.mvvmnewsapp.data.newsorg.NewsApi
import com.codinginflow.mvvmnewsapp.domain.model.Article
import com.codinginflow.mvvmnewsapp.domain.model.asDataBaseModel
import com.codinginflow.mvvmnewsapp.utlis.Resource
import com.codinginflow.mvvmnewsapp.utlis.performGetOperation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDao: NewsDao,
    private val newsApi: NewsApi
) {

    suspend fun getBreakingNews(): Flow<Resource<List<ArticleEntity>>> {
        return performGetOperation(
            databaseQuery = {
                newsDao.getBreakingNews()
            },
            networkCall = {
                val response = newsApi.getBreakingNews("us", 100)
                response.articles.asDataBaseModel()
            },
            saveCallResult = { newsDao.insertNews(it) })
    }

    suspend fun searchNews(query: String) {
        newsApi.searchNews(query, 1, 100)
    }


}