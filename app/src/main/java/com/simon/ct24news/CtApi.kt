package com.simon.ct24news

import retrofit2.Call
import retrofit2.http.GET

interface CtApi {
    @GET("/dapi/v4/section/113732?page=0&pageSize=20")
    fun getArticles() : Call<ArticlesResponse>
}