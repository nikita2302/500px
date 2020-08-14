package com.fivehunderedpx.challenge.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("format")
    val format: String,
    @SerializedName("https_url")
    val httpsUrl: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("url")
    val url: String
)