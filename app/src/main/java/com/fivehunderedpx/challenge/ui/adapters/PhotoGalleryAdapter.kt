package com.fivehunderedpx.challenge.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fivehunderedpx.challenge.R
import com.fivehunderedpx.challenge.model.Photo
import kotlinx.android.synthetic.main.photo_gallery_image.view.*

class PhotoGalleryAdapter(private val context: Context, private val photoClickListener: PhotoClickListener) : PagedListAdapter<Photo, PhotoGalleryViewHolder>(PhotoGalleryDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGalleryViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val inflatedView = inflater.inflate(R.layout.photo_gallery_image, parent, false)
        return PhotoGalleryViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: PhotoGalleryViewHolder, position: Int) {
        val photo = getItem(position)

        if(photo != null) {
            Log.d("debug", "$photo")
            holder.apply {

                Glide.with(ivGalleryImage.context).load(photo.imageUrl[0])
                    .into(ivGalleryImage)

          /*      GlideApp.with(context!!)
                    .load(image.imageUrl)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.ivGalleryImage)*/

                ivGalleryImage.setOnClickListener {
                    photoClickListener.onPhotoClicked(photo.id)
                }
            }
        }
    }
}

class PhotoGalleryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivGalleryImage = view.gallery_image
}

class PhotoGalleryDiffCallBack : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}

interface PhotoClickListener {
    fun onPhotoClicked(photoID: Int)
}