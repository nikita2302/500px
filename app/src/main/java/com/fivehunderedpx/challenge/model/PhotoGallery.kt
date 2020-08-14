package com.fivehunderedpx.challenge.model

import com.google.gson.annotations.SerializedName

data class PhotoGallery(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("feature")
    val feature: String,
    @SerializedName("filters")
    val filters: Filters,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("total_items")
    val totalItems: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)