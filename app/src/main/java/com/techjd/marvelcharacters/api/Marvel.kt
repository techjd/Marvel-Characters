package com.techjd.marvelcharacters.api



import com.techjd.marvelcharacters.models.characters.characters
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface Marvel {

    @GET("characters")
    fun getData(
        @Query("ts") ts: String?,
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?
    ): Call<characters>


}