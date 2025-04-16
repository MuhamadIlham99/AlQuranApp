package com.example.alquranapp.data.response

data class AyatResponse(
    val code: Int,
    val status: String,
    val data: SurahDetail
)

data class SurahDetail(
    val number: Int,
    val name: String,
    val englishName: String,
    val numberOfAyahs: Int,
    val ayahs: List<Ayah>
)

data class Ayah(
    val number: Int,
    val text: String,
    val numberInSurah: Int,
    val translation: Translation? = null
)

data class Translation(
    val text: String
)
