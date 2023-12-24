package mk.ukim.finki.mpip.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mk.ukim.finki.mpip.domain.model.Movie
import mk.ukim.finki.mpip.domain.repository.MovieRepository

class MovieDetailsViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private val detailsForMovieLiveData = MutableLiveData<Movie>()

    fun listAllDetails(movieId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieRepository.getMovie(movieId)
            detailsForMovieLiveData.postValue(movie)
        }
    }

    fun getDetailsForMovieLiveData(): LiveData<Movie> = detailsForMovieLiveData
}