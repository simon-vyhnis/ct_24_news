package com.simon.ct24news

data class ArticleInfo(val title: String, val type: String, val images : List<ImageLinks>, val applink: String){
    fun getId() : String{
        return applink.substringAfter("//", "null")
    }
}