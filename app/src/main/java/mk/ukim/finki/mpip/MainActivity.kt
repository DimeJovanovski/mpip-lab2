package mk.ukim.finki.mpip

import android.os.Bundle
import mk.ukim.finki.mpip.data.FakeApiProvider
import mk.ukim.finki.mpip.ui.fragments.AddNewMovieDialogFragment
import mk.ukim.finki.mpip.ui.fragments.MovieListFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import mk.ukim.finki.mpip.domain.repository.MovieRepository
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), AddNewMovieDialogFragment.AddMovieDialogListener {
    private lateinit var repository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragment_container_view, MovieListFragment())
                setReorderingAllowed(true)
            }
        }
        this.repository = MovieRepository(FakeApiProvider.getFakeApi())
    }

    override fun onDialogPositiveClick(
        // when clicking "ADD"
        title: String,
        description: String,
        director: String,
        actors: ArrayList<String>
    ) {
        repository.addMovie(title, description, director, actors)

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view, MovieListFragment())
            setReorderingAllowed(true)
        }
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        // when clicking "CANCEL"
        dialog.dismiss()
    }
}