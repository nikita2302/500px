package com.fivehunderedpx.challenge.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.fivehunderedpx.challenge.Constants
import com.fivehunderedpx.challenge.ui.viewmodels.MainActivityViewModel
import com.fivehunderedpx.challenge.R
import com.fivehunderedpx.challenge.ui.adapters.PhotoClickListener
import com.fivehunderedpx.challenge.ui.adapters.PhotoGalleryAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PhotoClickListener {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var photoGalleryAdapter: PhotoGalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainActivityViewModel(Constants.RECYCLER_VIEW_PAGE_SIZE) as T
            }
        }).get(MainActivityViewModel::class.java)

        photo_gallery_recycler_view.layoutManager = GridLayoutManager(this, Constants.SPAN_COUNT)
        photoGalleryAdapter = PhotoGalleryAdapter(this, this)
        photo_gallery_recycler_view.adapter = photoGalleryAdapter
        setObservers()

        //addNewFragment(PhotoGalleryFragment.newInstance(), Constants.PHOTO_GALLERY_FRAGMENT)
    }

    private fun setObservers(){
        mainActivityViewModel.photoGalleryList.observe(this, Observer {
            photoGalleryAdapter.submitList(it)
        })
    }

    override fun onPhotoClicked(photoID: Int) {

    }

    /* fun addNewFragment(fragment: Fragment, tag: String) {
         supportFragmentManager.beginTransaction()
             .replace(R.id.fragment_container, fragment, tag)
             .addToBackStack(null)
             .commit()
     }*/

}
