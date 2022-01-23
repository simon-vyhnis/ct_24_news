package com.simon.ct24news

import com.google.gson.annotations.SerializedName

data class Article(val title: String, val perex: String, @SerializedName("offlineContent") val content: String) {
}