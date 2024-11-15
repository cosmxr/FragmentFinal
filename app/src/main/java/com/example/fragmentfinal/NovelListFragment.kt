package com.example.fragmentfinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentfinal.databinding.FragmentNovelListBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class NovelListFragment : Fragment() {

    private var _binding: FragmentNovelListBinding? = null
    private val binding get() = _binding!!
    private val firestoreRepository = FirestoreRepository()
    private lateinit var novelasAdapter: NovelasAdapter
    private lateinit var favoriteNovelasAdapter: FavoriteNovelasAdapter
    private val favoriteNovelas = mutableListOf<Novela>()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNovelListBinding.inflate(inflater, container, false)
        sharedPreferences = SharedPreferences(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        loadNovelas()
        loadFavoriteNovelas()
    }

    private fun setupRecyclerView() {
        novelasAdapter = NovelasAdapter { novela ->
            toggleFavorite(novela)
        }
        binding.recyclerViewNovelas.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = novelasAdapter
        }

        favoriteNovelasAdapter = FavoriteNovelasAdapter(favoriteNovelas) { novela ->
            toggleFavorite(novela)
        }
        binding.recyclerViewFavoriteNovelas.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteNovelasAdapter
        }
    }

    private fun loadNovelas() {
        lifecycleScope.launch {
            val novelas = firestoreRepository.obtenerNovelas()
            novelasAdapter.submitList(novelas)
        }
    }

    private fun loadFavoriteNovelas() {
        lifecycleScope.launch {
            val userId = FirebaseAuth.getInstance().currentUser?.uid ?: "fixedUserId"
            val favoriteNovelsIds = sharedPreferences.getUserFavoriteNovels(userId)
            val allNovelas = firestoreRepository.obtenerNovelas()
            favoriteNovelas.clear()
            favoriteNovelas.addAll(allNovelas.filter { it.id in favoriteNovelsIds })
            favoriteNovelasAdapter.notifyDataSetChanged()
        }
    }

    private fun toggleFavorite(novela: Novela) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: "fixedUserId"
        val favoriteNovels = sharedPreferences.getUserFavoriteNovels(userId).toMutableList()
        if (novela.isFavorita) {
            favoriteNovels.remove(novela.id)
        } else {
            favoriteNovels.add(novela.id)
        }
        sharedPreferences.saveUserFavoriteNovels(userId, favoriteNovels)
        loadFavoriteNovelas()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}