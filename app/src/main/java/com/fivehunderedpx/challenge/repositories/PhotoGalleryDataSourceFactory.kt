package com.fivehunderedpx.challenge.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.fivehunderedpx.challenge.model.Photo
import kotlinx.coroutines.CoroutineScope

class PhotoGalleryDataSourceFactory(val viewModelScope: CoroutineScope): DataSource.Factory<Int, Photo>() {

    var photoGalleryLiveData = MutableLiveData<PageKeyedDataSource<Int, Photo>>()
    lateinit var photoGalleryDataSource: PhotoGalleryDataSource

    override fun create(): DataSource<Int, Photo> {
        photoGalleryDataSource = PhotoGalleryDataSource(viewModelScope)
        photoGalleryLiveData.postValue(photoGalleryDataSource)
        return photoGalleryDataSource
    }
}