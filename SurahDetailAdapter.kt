package com.example.alquranapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alquranapp.data.model.Ayat
import com.example.alquranapp.databinding.ItemAyatBinding
import com.example.alquranapp.ui.adapter.SurahDetailAdapter
class SurahDetailAdapter : RecyclerView.Adapter<SurahDetailAdapter.AyatViewHolder>() {

    private var ayatList: List<Ayat> = emptyList()

    // Membuat ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyatViewHolder {
        val binding = ItemAyatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AyatViewHolder(binding)
    }

    // Mengikat data ke ViewHolder
    override fun onBindViewHolder(holder: AyatViewHolder, position: Int) {
        val ayat = ayatList[position]
        holder.bind(ayat)
    }

    // Mengembalikan jumlah item
    override fun getItemCount(): Int = ayatList.size

    // Menyubmit list baru ke adapter
    fun submitList(list: List<Ayat>) {
        ayatList = list
        notifyDataSetChanged()  // Notify bahwa list telah diperbarui
    }

    // ViewHolder kelas untuk mengikat view
    class AyatViewHolder(private val binding: ItemAyatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ayat: Ayat) {
            binding.ayat = ayat // Bind data ke layout
            binding.executePendingBindings() // Eksekusi binding
        }
    }
}
