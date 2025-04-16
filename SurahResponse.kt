package com.example.alquranapp.data.response

import com.example.alquranapp.data.model.Surah

data class SurahResponse(
    val code: Int,
    val status: String,
    val data: List<Surah>
)
