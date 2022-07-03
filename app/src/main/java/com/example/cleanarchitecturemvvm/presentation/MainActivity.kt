package com.example.cleanarchitecturemvvm.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitecturemvvm.R
import com.example.cleanarchitecturemvvm.databinding.ActivityMainBinding
import com.example.cleanarchitecturemvvm.presentation.artist.ArtistActivity
import com.example.cleanarchitecturemvvm.presentation.movie.MovieActivity
import com.example.cleanarchitecturemvvm.presentation.tvshow.TvShowActivity

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setupEventListening()
    }

    private fun setupEventListening() {
        binding.btnArtists.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }
        binding.btnMovies.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }
        binding.btnTvShows.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }
    }
}