package com.example.newsapp.models

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("publishedAt")
    var timestamp: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("url")
    var url: String? = "",
    @SerializedName("urlToImage")
    var imageUrl: String? = ""
)