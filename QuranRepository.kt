package com.example.alquranapp.data.repository

import com.example.alquranapp.data.api.ApiClient
import com.example.alquranapp.data.model.Ayat
import com.example.alquranapp.data.model.Surah

class QuranRepository {

    suspend fun getAllSurah(): List<Surah> {
        val response = ApiClient.apiService.getSurahs() // Memanggil API untuk mendapatkan daftar Surah
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList() // Bisa mengembalikan daftar kosong jika gagal
        }
    }

    // Fungsi lain seperti getAyatBySurah bisa tetap ada di sini
    suspend fun getAyatBySurah(surahId: Int): List<Ayat> {
        val response = ApiClient.apiService.getAyatsBySurah(surahId)
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList() // Menangani kesalahan
        }
    }
}
