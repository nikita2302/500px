package com.fivehunderedpx.challenge.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewpager.widget.ViewPager
import com.fivehunderedpx.challenge.Constants
import com.fivehunderedpx.challenge.R
import com.fivehunderedpx.challenge.ui.ZoomOutPageTransformer
import com.fivehunderedpx.challenge.ui.activities.MainActivity
import com.fivehunderedpx.challenge.ui.adapters.PhotoPagerAdapter
import kotlinx.android.synthetic.main.fragment_photo_detail.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [PhotoDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PhotoDetailFragment : DialogFragment() {
    private var position: Int = 0
    private lateinit var layout: View
    lateinit var photoPagerAdapter: PhotoPagerAdapter
    private lateinit var _context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _context = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(Constants.POSITION)
        }
        setStyle(STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_photo_detail, container, false)
        photoPagerAdapter = PhotoPagerAdapter(_context, (activity as MainActivity).mainActivityViewModel.photoGalleryList)
        layout.photo_viewpager.adapter  = photoPagerAdapter
        layout.photo_viewpager.setCurrentItem(position, false)
        layout.photo_viewpager.addOnPageChangeListener(viewPagerPageChangeListener)
        layout.photo_viewpager.setPageTransformer(true, ZoomOutPageTransformer())
        val photo = (activity as MainActivity).mainActivityViewModel.photoGalleryList.value?.get(position)
        if(photo != null) {
            layout.photo_title.text = photo.name
            layout.photo_description.text = photo.description
        }
        return layout
    }

    var viewPagerPageChangeListener: ViewPager.OnPageChangeListener =
        object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                val photo = (activity as MainActivity).mainActivityViewModel.photoGalleryList.value?.get(position)
                if(photo != null) {
                    layout.photo_title.text = photo.name
                    layout.photo_description.text = photo.description
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {
            }

            override fun onPageScrollStateChanged(arg0: Int) {
            }
        }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PhotoDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(position: Int) =
            PhotoDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(Constants.POSITION, position)
                }
            }
    }
}
