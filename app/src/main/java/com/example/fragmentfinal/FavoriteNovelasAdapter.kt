package com.example.fragmentfinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentfinal.databinding.ItemNovelaBinding

class FavoriteNovelasAdapter(
    private val favoriteNovelas: List<Novela>,
    private val onToggleFavoriteClick: (Novela) -> Unit
) : RecyclerView.Adapter<FavoriteNovelasAdapter.FavoriteNovelaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteNovelaViewHolder {
        val binding = ItemNovelaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteNovelaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteNovelaViewHolder, position: Int) {
        val novela = favoriteNovelas[position]
        holder.bind(novela)
    }

    override fun getItemCount(): Int = favoriteNovelas.size

    inner class FavoriteNovelaViewHolder(private val binding: ItemNovelaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(novela: Novela) {
            binding.tvNombre.text = novela.nombre
            binding.tvAutor.text = novela.autor
            binding.tvAno.text = novela.año_publicacion.toString()
            binding.tvDescripcion.text = novela.descripcion
            binding.root.setOnClickListener {
                onToggleFavoriteClick(novela)
            }
        }
    }
}