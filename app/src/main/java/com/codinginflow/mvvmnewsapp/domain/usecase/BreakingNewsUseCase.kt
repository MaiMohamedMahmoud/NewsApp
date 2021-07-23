package com.codinginflow.mvvmnewsapp.domain.usecase

import com.codinginflow.mvvmnewsapp.data.repository.NewsRepository
import com.codinginflow.mvvmnewsapp.domain.model.Article
import javax.inject.Inject

class BreakingNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun getBreakingNews(): List<Article> =
        newsRepository.getBreakingNews()


}