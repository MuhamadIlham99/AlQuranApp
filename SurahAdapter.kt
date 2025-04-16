package com.example.alquranapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alquranapp.data.model.Surah
import com.example.alquranapp.databinding.ItemSurahBinding

class SurahAdapter(
    private val onItemClick: (Surah) -> Unit
) : RecyclerView.Adapter<SurahAdapter.SurahViewHolder>() {

    private var surahList: List<Surah> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val binding = ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SurahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val surah = surahList[position]
        holder.bind(surah, onItemClick)
    }

    override fun getItemCount(): Int = surahList.size

    fun submitList(list: List<Surah>) {
        surahList = list
        notifyDataSetChanged()
    }

    class SurahViewHolder(private val binding: ItemSurahBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: Surah, onItemClick: (Surah) -> Unit) {
            binding.surah = surah
            binding.root.setOnClickListener {
                onItemClick(surah)
            }
            binding.executePendingBindings()
        }
    }
}
