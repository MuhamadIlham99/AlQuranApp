package com.example.alquranapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alquranapp.data.model.Ayat
import com.example.alquranapp.data.repository.QuranRepository
import kotlinx.coroutines.launch

class SurahDetailViewModel(private val repository: QuranRepository) : ViewModel() {

    private val _ayatList = MutableLiveData<List<Ayat>>()
    val ayatList: LiveData<List<Ayat>> = _ayatList

    // Fungsi untuk mengambil ayat berdasarkan surahId
    fun getAyatBySurah(surahId: Int) {
        viewModelScope.launch {
            // Memanggil API melalui repository untuk mengambil data ayat berdasarkan surahId
            val ayats = repository.getAyatBySurah(surahId)
            _ayatList.value = ayats
        }
    }
}
