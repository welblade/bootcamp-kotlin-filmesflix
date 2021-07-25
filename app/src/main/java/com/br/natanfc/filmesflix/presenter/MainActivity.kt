package com.br.natanfc.filmesflix.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.br.natanfc.filmesflix.databinding.ActivityMainBinding
import com.br.natanfc.filmesflix.domain.Movie
import com.br.natanfc.filmesflix.framework.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        setListeners()
        loadingVisibility(true)
        setContentView(activityMainBinding.root)
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this, { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        activityMainBinding.moviesList.apply {
            hasFixedSize()
            this@MainActivity.adapter.setMovieList(list)
            adapter = this@MainActivity.adapter
        }
    }

    private fun setListeners(){
        adapter.movieClickListener = {
            val intent = Intent(this, MovieDetailActivity::class.java).apply {
                putExtra("id", it)
            }
            startActivity(intent)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        activityMainBinding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}