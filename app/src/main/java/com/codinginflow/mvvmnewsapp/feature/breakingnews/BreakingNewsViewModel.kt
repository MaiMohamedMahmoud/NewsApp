package com.codinginflow.mvvmnewsapp.feature.breakingnews

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinginflow.mvvmnewsapp.data.network.NewsArticleDto
import com.codinginflow.mvvmnewsapp.domain.usecase.BreakingNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakingNewsViewModel @Inject constructor(private val breakingNewsUseCase: BreakingNewsUseCase) :
    ViewModel() {

    private val breakingNewsMutableListDto: MutableLiveData<List<NewsArticleDto>> = MutableLiveData()
    val breakingNewsLiveDataDto: LiveData<List<NewsArticleDto>>
        get() = breakingNewsMutableListDto


    init {
        Log.i("yarab","Here is model load")
        loadAllBreakingNews()
    }

    private fun loadAllBreakingNews() {
        viewModelScope.launch {
            val breakingNewsList = breakingNewsUseCase.getBreakingNews()
            breakingNewsMutableListDto.value = breakingNewsList
        }

    }
}