package com.fivehunderedpx.challenge.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("about")
    val about: String,
    @SerializedName("active")
    val active: Int,
    @SerializedName("affection")
    val affection: Int,
    @SerializedName("avatar_version")
    val avatarVersion: Int,
    @SerializedName("avatars")
    val avatars: Avatars,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("cover_url")
    val coverUrl: Any,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("followers_count")
    val followersCount: Int,
    @SerializedName("following")
    val following: Boolean,
    @SerializedName("fullname")
    val fullname: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("registration_date")
    val registrationDate: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("upgrade_status")
    val upgradeStatus: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("userpic_https_url")
    val userpicHttpsUrl: String,
    @SerializedName("userpic_url")
    val userpicUrl: String,
    @SerializedName("usertype")
    val usertype: Int
)