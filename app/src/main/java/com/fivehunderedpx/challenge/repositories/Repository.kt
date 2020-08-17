package com.fivehunderedpx.challenge.repositories

import com.fivehunderedpx.challenge.apis.Result
import com.fivehunderedpx.challenge.apis.RetrofitBuilder
import com.fivehunderedpx.challenge.model.PhotoGallery

/**
 * Repository class is not used for the current project.
 * However if there is any other API call where paging is not required it will be coded here.
 * For paging a separate data source class is preferred
 */
object Repository {

    /**
    * Example for how I would make other API calls where paging is not required.
    * This method is not used since the get API is called in the Data Source class for paging
    */
    suspend fun getGalleryImage(): Result<PhotoGallery> {
        return RetrofitBuilder.safeApiCall {
            RetrofitBuilder.photoAPIs.getPhotos(page = 1, imageSize = 3)
        }
    }
}