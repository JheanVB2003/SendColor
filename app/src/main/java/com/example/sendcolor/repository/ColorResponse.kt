package com.example.sendcolor.repository

import com.google.gson.annotations.SerializedName

data class ColorResponse(
    val color: ColorDetails
)

data class ColorDetails(
    val name: String,
    @SerializedName("hex") val hexCode: String?,
    @SerializedName("rgb") val rgb: RGB?,
    val hsl: String,
    val luminance: Double,
    val description: String,
    val psychologyTags: List<String>,
    val colorPalette: List<ColorItem>,
    val complementaryColor: String,
    val hexVariations: List<String>,
    val colorCategory: String,
    val designUsageSuggestions: List<String>,
    val accessibleOnWhite: Boolean,
    val accessibleOnBlack: Boolean
)

data class RGB(
    val red: Int,
    val green: Int,
    val blue: Int
)

data class ColorItem(
    val name: String,
    val hex: String
)
