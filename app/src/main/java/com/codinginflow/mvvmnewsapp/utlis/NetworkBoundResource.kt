package com.codinginflow.mvvmnewsapp.utlis

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

//Request is the type of response Api
//Result is the type using in UI.
fun <Result, Request> performGetOperation(
    databaseQuery: () -> Flow<Result>,
    networkCall: suspend () -> Request,
    saveCallResult: suspend (Request) -> Unit
):Flow<Result> = channelFlow {
    val databaseResult = databaseQuery().first()
    send(databaseResult)
    try{
        saveCallResult(networkCall())
    }catch (error:Exception){

    }




}