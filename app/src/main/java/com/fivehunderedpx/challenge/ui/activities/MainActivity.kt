package com.fivehunderedpx.challenge.ui.activities

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
import com.fivehunderedpx.challenge.ui.fragments.PhotoDetailFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("UNCHECKED_CAST")
class MainActivity : AppCompatActivity(), PhotoClickListener {
    lateinit var mainActivityViewModel: MainActivityViewModel
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

        refresh_layout.setOnRefreshListener {
            mainActivityViewModel.refresh()
        }

        setObservers()
    }

    private fun setObservers(){
        mainActivityViewModel.photoGalleryList.observe(this, Observer {

            if (refresh_layout.isRefreshing) {
                refresh_layout.isRefreshing = false;
            }

            photoGalleryAdapter.submitList(it)
        })

        mainActivityViewModel.photoGalleryPagedListError.observe(this, Observer {
            Snackbar.make(
                activity_layout,
                getString(R.string.try_again),
                Snackbar.LENGTH_LONG
            ).show()
        })
    }

    override fun onPhotoClicked(position: Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = PhotoDetailFragment.newInstance(position)
        fragment.show(fragmentTransaction, Constants.PHOTO_DETAIL_FRAGMENT)
    }
}
