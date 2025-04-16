package com.example.alquranapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alquranapp.data.repository.AyatRepository
import com.example.alquranapp.databinding.ActivitySurahDetailBinding
import com.example.alquranapp.ui.adapter.SurahDetailAdapter
import com.example.alquranapp.viewmodel.AyatViewModel
import com.example.alquranapp.viewmodel.AyatViewModelFactory

class SurahDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySurahDetailBinding
    private lateinit var ayatAdapter: SurahDetailAdapter
    private val viewModel: AyatViewModel by viewModels {
        AyatViewModelFactory(AyatRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurahDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surahId = intent.getIntExtra("surah_id", 1) // default ke 1 kalau tidak dikirim

        setupRecyclerView()
        observeViewModel()

        viewModel.getAyat(surahId)
    }

    private fun setupRecyclerView() {
        ayatAdapter = SurahDetailAdapter()
        binding.rvAyat.apply {
            layoutManager = LinearLayoutManager(this@SurahDetailActivity)
            adapter = ayatAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.ayatList.observe(this) { ayatList ->
            ayatAdapter.submitList(ayatList)
        }
    }
}
