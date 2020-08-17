package com.fivehunderedpx.challenge

/**
* A singleton class containing all the constants used in the app.
* All string constants that might require translation should not be added here they
* should be part of strings.xml file.
*/
object Constants {

    const val BASE_URL = "https://api.500px.com"
    const val RECYCLER_VIEW_PAGE_SIZE = 20
    const val FIRST_PAGE = 1
    const val ERROR = "error"
    const val UNAUTHORIZED = "unauthorized"
    const val NETWORK_ERROR = "networkError"

    // Gallery View Grid Columns
    const val SPAN_COUNT = 2

    //Fragment Tags
    const val PHOTO_DETAIL_FRAGMENT = "photoDetailFragment"

    //Fragment Parameters
    const val POSITION = "position"

    const val MIN_SCALE = 0.75f
}