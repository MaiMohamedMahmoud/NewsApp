package com.codinginflow.mvvmnewsapp.feature.breakingnews

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinginflow.mvvmnewsapp.domain.model.Article
import com.codinginflow.mvvmnewsapp.domain.usecase.BreakingNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakingNewsViewModel @Inject constructor(private val breakingNewsUseCase: BreakingNewsUseCase) :
    ViewModel() {

    val breakingNewsList = breakingNewsUseCase.getBreakingNews()

//    private val breakingNewsMutableFlow: MutableStateFlow<List<Article>> =
//        MutableStateFlow(emptyList())
//    val breakingNewsFlow: StateFlow<List<Article>>
//        get() = breakingNewsMutableFlow
//
//
//    init {
//
//        loadAllBreakingNews()
//    }
//
//    private fun loadAllBreakingNews() {
//        viewModelScope.launch {
//            val breakingNewsList = breakingNewsUseCase.getBreakingNews()
//            breakingNewsMutableFlow.value = breakingNewsList
//        }
//
//    }
}