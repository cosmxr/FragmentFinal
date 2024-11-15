package com.example.fragmentfinal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentfinal.databinding.ItemNovelaBinding

class NovelasAdapter(
    private val onToggleFavoriteClick: (Novela) -> Unit
) : RecyclerView.Adapter<NovelasAdapter.NovelaViewHolder>() {

    private var novelas: List<Novela> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelaViewHolder {
        val binding = ItemNovelaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NovelaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NovelaViewHolder, position: Int) {
        holder.bind(novelas[position])
    }

    override fun getItemCount(): Int = novelas.size

    fun submitList(novelas: List<Novela>) {
        this.novelas = novelas
        notifyDataSetChanged()
    }

    inner class NovelaViewHolder(private val binding: ItemNovelaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(novela: Novela) {
            binding.tvNombre.text = novela.nombre
            binding.tvAutor.text = novela.autor
            binding.tvAno.text = novela.año_publicacion.toString()
            binding.tvDescripcion.text = novela.descripcion
            binding.btnFavorite.setOnClickListener {
                onToggleFavoriteClick(novela)
            }
        }
    }
}