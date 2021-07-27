package com.codinginflow.mvvmnewsapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.codinginflow.mvvmnewsapp.data.localdb.NewsArticleDatabase
import com.codinginflow.mvvmnewsapp.data.localdb.NewsDao
import com.codinginflow.mvvmnewsapp.data.newsorg.NewsApi
import com.codinginflow.mvvmnewsapp.data.repository.NewsRepository
import com.codinginflow.mvvmnewsapp.domain.usecase.BreakingNewsUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * retrofit need 2 things in order to work :
     * 1- Base Url
     * 2- Converter factory which is here Gson...
     */

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(NewsApi.BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext app: Context): NewsArticleDatabase =
        NewsArticleDatabase.getDatabase(app)


    @Singleton
    @Provides
    fun provideNewsDao(db: NewsArticleDatabase): NewsDao = db.newsArticleDao()


    @Provides
    fun provideNewsRepository(newsDb: NewsArticleDatabase, newsApi: NewsApi): NewsRepository =
        NewsRepository(newsDb, newsApi)

    @Provides
    fun provideUseCase(repository: NewsRepository): BreakingNewsUseCase =
        BreakingNewsUseCase(repository)
}