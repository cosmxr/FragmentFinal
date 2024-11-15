// File: app/src/main/java/com/example/fragmentfinal/MainActivity.kt
package com.example.fragmentfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.fragmentfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseAuthHelper.signIn { isSuccess ->
            if (isSuccess) {
                setSupportActionBar(binding.toolbar)

                val navHostFragment = supportFragmentManager
                    .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController = navHostFragment.navController
                setupActionBarWithNavController(navController)
            } else {
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navController.navController.navigateUp() || super.onSupportNavigateUp()
    }
}