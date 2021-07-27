package com.codinginflow.mvvmnewsapp.domain.usecase

import com.codinginflow.mvvmnewsapp.data.repository.NewsRepository
import com.codinginflow.mvvmnewsapp.domain.model.Article
import com.codinginflow.mvvmnewsapp.utlis.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BreakingNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    fun getBreakingNews(): Flow<Resource<List<Article>>> =
        newsRepository.getBreakingNews()
}