package com.fivehunderedpx.challenge.model

import com.google.gson.annotations.SerializedName

data class Avatars(
    @SerializedName("default")
    val default: Default,
    @SerializedName("large")
    val large: Large,
    @SerializedName("small")
    val small: Small,
    @SerializedName("tiny")
    val tiny: Tiny
)