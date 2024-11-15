package com.example.fragmentfinal

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUserFavoriteNovels(userId: String, favoriteNovels: List<String>) {
        val editor = sharedPreferences.edit()
        editor.putStringSet("$userId-favorites", favoriteNovels.toSet())
        editor.apply()
    }

    fun getUserFavoriteNovels(userId: String): List<String> {
        return sharedPreferences.getStringSet("$userId-favorites", emptySet())?.toList() ?: emptyList()
    }
}