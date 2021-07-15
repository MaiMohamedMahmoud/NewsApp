package com.codinginflow.mvvmnewsapp.data.localdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breaking_news")
data class BreakingNewsEntity(
    val newsUrl: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
