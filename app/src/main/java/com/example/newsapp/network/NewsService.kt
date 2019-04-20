package com.example.newsapp.network

import com.example.newsapp.models.NewsListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by sidharthsethia on 2019-04-20.
 */
interface NewsService {
    @GET("v2/top-headlines")
    fun getUserAddresses(
        @Query("country") country: String?,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Call<NewsListResponse>
}