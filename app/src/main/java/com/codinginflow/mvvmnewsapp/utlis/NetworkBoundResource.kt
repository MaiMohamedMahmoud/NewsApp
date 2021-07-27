package com.codinginflow.mvvmnewsapp.utlis

import androidx.lifecycle.map
import kotlinx.coroutines.flow.*

//Request is the type of response Api
//Result is the type using in UI.
fun <Result, Request> performGetOperation(
    databaseQuery: () -> Flow<Result>,
    networkCall: suspend () -> Request,
    saveCallResult: suspend (Request) -> Unit
) = channelFlow {
//    val databaseResult = databaseQuery().first()
//
//    val loading = databaseQuery().collect {
//        send(Resource.Loading(it))
//    }
//    try {
//        saveCallResult(networkCall())
//        databaseQuery().collect {
//            send(Resource.Success(it))
//        }
//    } catch (error: Exception) {
//        databaseQuery().collect {
//            send(Resource.Error(error, it))
//        }
//    }

    val source = databaseQuery()
    //attached this source of livedata to the ui livedata.
    databaseQuery().collect {  send(Resource.Loading(it))}
    saveCallResult(networkCall())
    databaseQuery().collect { send(Resource.Success(it)) }

}