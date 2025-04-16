package com.example.alquranapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alquranapp.data.repository.AyatRepository

class AyatViewModelFactory(private val repository: AyatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AyatViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AyatViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
