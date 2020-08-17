package com.fivehunderedpx.challenge.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("aperture")
    val aperture: String,
    @SerializedName("camera")
    val camera: String,
    @SerializedName("category")
    val category: Int,
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("editored_by")
    val editoredBy: Any,
    @SerializedName("editors_choice")
    val editorsChoice: Boolean,
    @SerializedName("editors_choice_date")
    val editorsChoiceDate: Any,
    @SerializedName("feature")
    val feature: String,
    @SerializedName("feature_date")
    val featureDate: String,
    @SerializedName("fill_switch")
    val fillSwitch: FillSwitch,
    @SerializedName("focal_length")
    val focalLength: String,
    @SerializedName("has_nsfw_tags")
    val hasNsfwTags: Boolean,
    @SerializedName("height")
    val height: Int,
    @SerializedName("highest_rating")
    val highestRating: Double,
    @SerializedName("highest_rating_date")
    val highestRatingDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_format")
    val imageFormat: String,
    @SerializedName("image_url")
    val imageUrl: List<String>,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("iso")
    val iso: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("lens")
    val lens: String,
    @SerializedName("liked")
    val liked: Any,
    @SerializedName("location")
    val location: String,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("nsfw")
    val nsfw: Boolean,
    @SerializedName("positive_votes_count")
    val positiveVotesCount: Int,
    @SerializedName("privacy")
    val privacy: Boolean,
    @SerializedName("privacy_level")
    val privacyLevel: Int,
    @SerializedName("profile")
    val profile: Boolean,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("shutter_speed")
    val shutterSpeed: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("taken_at")
    val takenAt: Any,
    @SerializedName("times_viewed")
    val timesViewed: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("voted")
    val voted: Any,
    @SerializedName("votes_count")
    val votesCount: Int,
    @SerializedName("watermark")
    val watermark: Boolean,
    @SerializedName("width")
    val width: Int
)