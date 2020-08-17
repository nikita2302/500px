package com.fivehunderedpx.challenge.model

import com.google.gson.annotations.SerializedName

data class FillSwitch(
    @SerializedName("access_deleted")
    val accessDeleted: Boolean,
    @SerializedName("access_private")
    val accessPrivate: Boolean,
    @SerializedName("always_exclude_nude")
    val alwaysExcludeNude: Boolean,
    @SerializedName("current_user_id")
    val currentUserId: Any,
    @SerializedName("exclude_block")
    val excludeBlock: Boolean,
    @SerializedName("exclude_nude")
    val excludeNude: Boolean,
    @SerializedName("exclude_private")
    val excludePrivate: Boolean,
    @SerializedName("include_admin_locks")
    val includeAdminLocks: Boolean,
    @SerializedName("include_comments")
    val includeComments: Boolean,
    @SerializedName("include_deleted")
    val includeDeleted: Boolean,
    @SerializedName("include_equipment_info")
    val includeEquipmentInfo: Boolean,
    @SerializedName("include_follow_info")
    val includeFollowInfo: Boolean,
    @SerializedName("include_geo")
    val includeGeo: Boolean,
    @SerializedName("include_licensing")
    val includeLicensing: Boolean,
    @SerializedName("include_like_by")
    val includeLikeBy: Boolean,
    @SerializedName("include_tags")
    val includeTags: Boolean,
    @SerializedName("include_user_info")
    val includeUserInfo: Boolean,
    @SerializedName("only_user_active")
    val onlyUserActive: Boolean
)