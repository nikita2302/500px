package com.fivehunderedpx.challenge.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.fivehunderedpx.challenge.R
import com.fivehunderedpx.challenge.model.Photo
import kotlinx.android.synthetic.main.image_view_pager.view.*

class PhotoPagerAdapter(private val context: Context, private val photoList: LiveData<PagedList<Photo>>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = layoutInflater.inflate(R.layout.image_view_pager, container, false)

        val photo = photoList.value?.get(position)

        // load image
        if(photo != null) {
            Glide.with(layout.large_photo.context).load(photo.imageUrl[0])
                .into(layout.large_photo)
        }

        container.addView(layout)

        return layout
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj as View
    }

    override fun getCount() = photoList.value?.size ?: 0

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}