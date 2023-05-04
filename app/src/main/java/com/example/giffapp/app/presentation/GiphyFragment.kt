package com.example.giffapp.app.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giffapp.data.GiphyService
import com.example.giffapp.data.model.GiphyData
import com.example.giffapp.data.model.GiphyModel
import com.example.giffapp.databinding.FragmentGiphyBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val TAG = "Fragment"
class GiphyFragment : Fragment() {

    lateinit var binding: FragmentGiphyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentGiphyBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding.recyclerView

        val gifs = mutableListOf<GiphyData>()
        val adapter = context?.let { GifsAdapter(it, gifs) }

        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retroService = retrofit.create(GiphyService::class.java)
        retroService.getGifs().enqueue(object  : Callback<GiphyModel?>{
            override fun onResponse(call: Call<GiphyModel?>, response: Response<GiphyModel?>) {
                val body = response.body()
                if (body == null) {
                    Log.d(TAG, "onResponse: No response...")
                }
                //add to list
                gifs.addAll(body!!.res)
            }

            override fun onFailure(call: Call<GiphyModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}