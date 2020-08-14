package com.fivehunderedpx.challenge.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fivehunderedpx.challenge.R
import kotlinx.android.synthetic.main.fragment_photo_gallery.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [PhotoGalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PhotoGalleryFragment : Fragment() {
    private lateinit var layout: View
    private lateinit var photoGalleryRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout =  inflater.inflate(R.layout.fragment_photo_gallery, container, false)

        photoGalleryRecyclerView = layout.photo_gallery_recycler_view

        return layout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PhotoGalleryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = PhotoGalleryFragment()
    }
}
