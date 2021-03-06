package com.simon.ct24news

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CtApi {
    @GET("/dapi/v4/section/113732?page=0&pageSize=20")
    fun getArticles() : Call<ArticlesResponse>

    @GET("/dapi/v4/{id}")
    fun getArticle(@Path("id") id: String) : Call<ArticleResponse>
}