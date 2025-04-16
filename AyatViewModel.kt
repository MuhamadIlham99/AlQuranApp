package com.example.alquranapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alquranapp.data.model.Ayat
import com.example.alquranapp.data.repository.AyatRepository
import kotlinx.coroutines.launch

class AyatViewModel(private val repository: AyatRepository) : ViewModel() {

    private val _ayatList = MutableLiveData<List<Ayat>>()
    val ayatList: LiveData<List<Ayat>> = _ayatList

    fun getAyat(surahId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getAyatBySurahId(surahId)
                if (response.isSuccessful && response.body() != null) {
                    _ayatList.value = response.body()!!
                }
            } catch (e: Exception) {
                // handle error
                e.printStackTrace()
            }
        }
    }
}
