package mk.ukim.finki.mpip.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mk.ukim.finki.mpip.domain.model.Movie
import mk.ukim.finki.mpip.domain.repository.MovieRepository

class MovieListViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private val moviesLiveData = MutableLiveData<List<Movie>>()

    fun getMovieLiveData(): LiveData<List<Movie>> = moviesLiveData

    fun listAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.listMovies()
            moviesLiveData.postValue(movies)
        }
    }
}