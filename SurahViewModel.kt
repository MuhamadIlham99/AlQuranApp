package com.example.alquranapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alquranapp.data.model.Surah
import com.example.alquranapp.data.repository.QuranRepository
import kotlinx.coroutines.launch

class SurahViewModel(private val repository: QuranRepository) : ViewModel() {

    private val _surahList = MutableLiveData<List<Surah>>()
    val surahList: LiveData<List<Surah>> = _surahList

    fun getAllSurah() {
        viewModelScope.launch {
            val surahs = repository.getAllSurah()
            _surahList.value = surahs
        }
    }
}
