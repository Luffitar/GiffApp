package com.example.giffapp.data

import com.example.giffapp.data.model.GiphyModel
import retrofit2.http.GET

interface GiphyService {

    @GET("gifs/trending?api_key=fuRz4JlDwryoLtKsAsmIrq55VC7ejgrO")
    fun getGifs(): retrofit2.Call<GiphyModel>

}