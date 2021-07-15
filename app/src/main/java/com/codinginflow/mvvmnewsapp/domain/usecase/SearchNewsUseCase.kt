package com.codinginflow.mvvmnewsapp.domain.usecase

import com.codinginflow.mvvmnewsapp.data.repository.NewsRepository
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun searchNews(query: String) {
        newsRepository.searchNews(query)
    }
}