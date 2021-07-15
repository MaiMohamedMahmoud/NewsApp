package com.codinginflow.mvvmnewsapp.domain.usecase

import com.codinginflow.mvvmnewsapp.data.network.NewsArticleDto
import com.codinginflow.mvvmnewsapp.data.repository.NewsRepository
import javax.inject.Inject

class BreakingNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun getBreakingNews(): List<NewsArticleDto> =
        newsRepository.getBreakingNews()


}