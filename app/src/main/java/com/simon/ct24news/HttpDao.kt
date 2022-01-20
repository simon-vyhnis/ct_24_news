package com.simon.ct24news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpDao {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://ct24.ceskatelevize.cz/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //TODO create retrofit functions here

        val articles = MutableLiveData<ArticlesResponse>();
        fun getArticles(): LiveData<ArticlesResponse> {
            Log.i("HTTP","Getting articles")
            val api = retrofit.create(CtApi::class.java)
            val call = api.getArticles()
            call.enqueue(object :Callback<ArticlesResponse>{
                override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>
                ) {
                    if(response.isSuccessful) {
                        articles.postValue(response.body())
                    }else{
                        Log.e("HTTP",""+response.code())
                    }
                }

                override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                    t.printStackTrace()
                }

            })
            return articles
        }
}