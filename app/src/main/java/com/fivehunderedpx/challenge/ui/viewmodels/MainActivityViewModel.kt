package com.fivehunderedpx.challenge.ui.viewmodels

import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.fivehunderedpx.challenge.model.Photo
import com.fivehunderedpx.challenge.repositories.PhotoGalleryDataSource

class MainActivityViewModel(val pageSize: Int): ViewModel() {
    var photoGalleryList: LiveData<PagedList<Photo>>
    var photoGalleryPagedListError: LiveData<String>
    private lateinit var photoGalleryDataSource: PhotoGalleryDataSource

    init {
        val config: PagedList.Config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setEnablePlaceholders(false)
            .build()

        val dataSourceFactory = object : DataSource.Factory<Int, Photo>() {

            val photoGalleryPagedData = MutableLiveData<PageKeyedDataSource<Int, Photo>>()
            lateinit var photoGalleryPagedDataSource: PhotoGalleryDataSource
            override fun create(): DataSource<Int, Photo> {
                photoGalleryPagedDataSource = PhotoGalleryDataSource(viewModelScope)
                photoGalleryDataSource = photoGalleryPagedDataSource
                photoGalleryPagedData.postValue(photoGalleryPagedDataSource)
                return photoGalleryPagedDataSource
            }
        }

        photoGalleryPagedListError = Transformations.switchMap(dataSourceFactory.photoGalleryPagedData) {
            dataSourceFactory.photoGalleryPagedDataSource.photoGalleryErrorMessage
        }

        photoGalleryList = LivePagedListBuilder(dataSourceFactory, config).build()

    }

    fun refresh() {
        photoGalleryDataSource.invalidate()
    }
}