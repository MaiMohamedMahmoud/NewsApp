package com.codinginflow.mvvmnewsapp.data.localdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArticleEntity::class], version = 1)
abstract class NewsArticleDatabase : RoomDatabase() {

    abstract fun newsArticleDao(): NewsDao
}