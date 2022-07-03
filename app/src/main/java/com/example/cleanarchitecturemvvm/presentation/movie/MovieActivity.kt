package com.example.cleanarchitecturemvvm.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturemvvm.R
import com.example.cleanarchitecturemvvm.databinding.ActivityMovieBinding
import com.example.cleanarchitecturemvvm.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieActivity : BaseActivity() {
    @Inject
    lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        movieViewModel.getMovies().observe(this){
            Log.e("----", it.size.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}