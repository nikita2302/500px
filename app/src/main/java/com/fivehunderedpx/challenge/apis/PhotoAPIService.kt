package com.fivehunderedpx.challenge.apis

import com.fivehunderedpx.challenge.BuildConfig
import com.fivehunderedpx.challenge.model.PhotoGallery
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoAPIService {

    @GET("/v1/photos")
    suspend fun getPhotos(@Query("consumer_key") apiKey: String = BuildConfig.API_KEY, @Query("page") page: Int, @Query("rpp") limit: Int = 20, @Query("image_size") imageSize: Int = 3, @Query("feature") feature: String = "popular", @Query("sort") sortBy: String = "created_at"): Response<PhotoGallery>
}