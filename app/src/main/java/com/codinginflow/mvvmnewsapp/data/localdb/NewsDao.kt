package com.codinginflow.mvvmnewsapp.data.localdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("Select * from news_articles")
    fun getBreakingNews(): Flow<List<ArticleEntity>>

    @Query("Select * from news_articles where isBookmarked = 1 ")
    fun getBookMarkedNews(): Flow<ArticleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreakingNews(breakingNewsList: List<ArticleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(NewsList: List<ArticleEntity>)

}