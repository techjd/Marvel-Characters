package com.techjd.marvelcharacters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techjd.marvelcharacters.R
import com.techjd.marvelcharacters.adapters.CharactersAdapter
import com.techjd.marvelcharacters.api.APIService
import com.techjd.marvelcharacters.models.characters.characters
import com.techjd.marvelcharacters.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(this)

        APIService.instance.getData(Constants.ts, Constants.APIKEY, Constants.hash)
            .enqueue(object : Callback<characters> {
                override fun onFailure(call: Call<characters>, t: Throwable) {
                    progressBar.visibility = View.GONE
                }

                override fun onResponse(call: Call<characters>, response: Response<characters>) {


                    recyclerView.adapter =
                        CharactersAdapter(response.body()!!.data.results, this@MainActivity)
                    progressBar.visibility = View.GONE
                }

            })
    }
}