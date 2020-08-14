package com.fivehunderedpx.challenge.repositories

import com.fivehunderedpx.challenge.apis.Result
import com.fivehunderedpx.challenge.apis.RetrofitBuilder
import com.fivehunderedpx.challenge.model.PhotoGallery

object Repository {

    suspend fun getGalleryImage(): Result<PhotoGallery> {
        return RetrofitBuilder.safeApiCall {
            RetrofitBuilder.photoAPIs.getPhotos(page = 1, imageSize = 3)
        }
    }
}