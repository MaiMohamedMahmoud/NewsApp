package com.codinginflow.mvvmnewsapp.data.network

import com.codinginflow.mvvmnewsapp.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = BuildConfig.NEWS_API_ACCESS_KEY
    }

    @Headers("X-Api-Key: $API_KEY")
    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("country") country: String,
        @Query("pageSize") pageSize: Int
    ): NewsArticleResponse

    @Headers("X-Api-Key: $API_KEY")
    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsArticleResponse

}