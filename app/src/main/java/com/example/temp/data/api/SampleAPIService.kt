package com.example.temp.data.api

import com.example.temp.data.api.entity.SpreadSheet
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface SampleAPIService{
    @GET
    fun getSpreadSheet(@Url url:String):Single<Response<List<SpreadSheet>>>
}