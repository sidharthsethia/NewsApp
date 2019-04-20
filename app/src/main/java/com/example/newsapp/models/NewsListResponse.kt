package com.example.newsapp.models

import com.google.gson.annotations.SerializedName

data class NewsListResponse(
    @SerializedName("articles")
    var articles: List<Article?>? = listOf(),
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("totalResults")
    var totalResults: Int? = 0
)