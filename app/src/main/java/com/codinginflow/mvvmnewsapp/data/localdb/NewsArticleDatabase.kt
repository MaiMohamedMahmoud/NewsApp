package com.codinginflow.mvvmnewsapp.data.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ArticleEntity::class], version = 1)
abstract class NewsArticleDatabase : RoomDatabase() {

    abstract fun newsArticleDao(): NewsDao

    companion object {
        @Volatile private var instance: NewsArticleDatabase? = null

        fun getDatabase(context: Context): NewsArticleDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, NewsArticleDatabase::class.java, "news_database")
                .fallbackToDestructiveMigration().build()
    }
}