package com.example.giffapp.data.model

import com.google.gson.annotations.SerializedName

data class GiphyModel(
    @SerializedName("data")
    val res: List<GiphyData>,
)

data class GiphyData(
    @SerializedName("images")
    val images: GiphyImage,
)

data class GiphyImage(
    @SerializedName("original")
    val ogImage: OgImage,
)

data class OgImage(
    @SerializedName("url")
    val url: String,
)