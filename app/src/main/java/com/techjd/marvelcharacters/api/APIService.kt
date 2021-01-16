package com.techjd.marvelcharacters.api

import com.techjd.marvelcharacters.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object APIService {
    val instance: Marvel

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.URL)
            .addConverterFactory(GsonConverterFactory.create())

            .build()
        instance = retrofit.create(Marvel::class.java)
    }
}