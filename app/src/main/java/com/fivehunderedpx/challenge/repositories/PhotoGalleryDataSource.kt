package com.fivehunderedpx.challenge.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.fivehunderedpx.challenge.Constants
import com.fivehunderedpx.challenge.apis.RetrofitBuilder
import com.fivehunderedpx.challenge.model.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PhotoGalleryDataSource(private val scope: CoroutineScope): PageKeyedDataSource<Int, Photo>() {

    val photoGalleryErrorMessage : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private var page = Constants.FIRST_PAGE

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Photo>
    ) {
        scope.launch {
            when (val photoGalleryResponse =  RetrofitBuilder.safeApiCall {
                RetrofitBuilder.photoAPIs.getPhotos(
                    page = page,
                    limit = params.requestedLoadSize)
            }) {
                is com.fivehunderedpx.challenge.apis.Result.Success -> {

                    callback.onResult(photoGalleryResponse.data.photos, null, page + 1)
                }

                is com.fivehunderedpx.challenge.apis.Result.ErrorString -> {
                    photoGalleryErrorMessage.value = Constants.ERROR
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        scope.launch {
            when (val photoGalleryResponse =  RetrofitBuilder.safeApiCall {
                RetrofitBuilder.photoAPIs.getPhotos(
                    page = params.key,
                    limit = params.requestedLoadSize)
            }) {
                is com.fivehunderedpx.challenge.apis.Result.Success -> {

                    if(photoGalleryResponse.data.totalPages >= params.key) {
                        callback.onResult(photoGalleryResponse.data.photos, params.key+1)
                    } else {
                        // End of list
                    }
                }

                is com.fivehunderedpx.challenge.apis.Result.ErrorString -> {
                    photoGalleryErrorMessage.value = Constants.ERROR
                }
            }
        }
    }

    /**
     * Have not overridden load before since the recycler view will hold the data
     * I have also tested this and while scrolling up data is always present
     * and shows up on the screen in correct order
     */
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
    }
}