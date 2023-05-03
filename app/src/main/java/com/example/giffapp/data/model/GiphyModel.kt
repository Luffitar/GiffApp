package com.example.giffapp.data.model

import com.google.gson.annotations.SerializedName

data class GiphyModel(
    @SerializedName("data")
    val data: List<GiphyData>,
)

data class GiphyData(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
)