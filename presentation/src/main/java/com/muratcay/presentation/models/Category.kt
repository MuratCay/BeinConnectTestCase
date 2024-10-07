package com.muratcay.presentation.models

sealed class Category(
    val title: String,
    val originalLanguage: String = "",
    val notOriginalLanguage: String = "",
    val releaseDateBefore: String = "",
    val releaseDateAfter: String = "",
    val minVoteAverage: String = ""
) {
    object Domestic : Category(
        title = "Yerli Filmler",
        originalLanguage = "tr"
    )

    object Foreign : Category(
        title = "Yabancı Filmler",
        notOriginalLanguage = "tr"
    )

    object Popular : Category(
        title = "Beğenilen Filmler",
        minVoteAverage = "8"
    )

    object OldTurkish : Category(
        title = "Yeşilçam Filmleri",
        originalLanguage = "tr",
        releaseDateBefore = "1985"
    )

    object News : Category(
        title = "Bu Senenin Filmleri",
        releaseDateAfter = "2021"
    )
}

val categories: List<Category> = listOf(
    Category.Domestic,
    Category.Popular,
    Category.OldTurkish,
    Category.News
)