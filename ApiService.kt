package com.example.alquranapp.data.api

import com.example.alquranapp.data.model.Ayat
import com.example.alquranapp.data.model.Surah
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // Mendapatkan daftar surah
    @GET("v1/surah")
    suspend fun getSurahs(): Response<List<Surah>>

    // Mendapatkan ayat berdasarkan ID surah
    @GET("v1/surah/{surahId}/ayah")
    suspend fun getAyatsBySurah(@Path("surahId") surahId: Int): Response<List<Ayat>>
}
