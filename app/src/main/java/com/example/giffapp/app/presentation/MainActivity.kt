package com.example.giffapp.app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.giffapp.R

const val BASE_URL = "https://api.giphy.com/v1/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}