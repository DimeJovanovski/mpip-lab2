package mk.ukim.finki.mpip.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.mpip.data.FakeApiProvider
import mk.ukim.finki.mpip.domain.repository.MovieRepository
import androidx.lifecycle.ViewModel
import android.content.Context

class MovieListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(
                MovieRepository(FakeApiProvider.getFakeApi())
            )
    }
}