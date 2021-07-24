package com.codinginflow.mvvmnewsapp.utlis

import com.codinginflow.mvvmnewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

fun <Result, Request> performGetOperation(
    databaseQuery: () -> Flow<Result>,
    networkCall: suspend () -> Request,
    saveCallResult: suspend (Request) -> Unit
){

}