package com.example.laboratorio05zac.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05zac.databinding.FragmentNewMovieBinding
import com.example.laboratorio05zac.ui.movie.viewmodel.MovieViewModel

class NewMovieFragment : Fragment(){

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentNewMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }

    private fun observeStatus(){
        movieViewModel.status.observe(viewLifecycleOwner) {
            status -> when {
            status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                Log.d(APP_TAG, status)
                movieViewModel.clearStatus()
            }

            status.equals(MovieViewModel.MOVIE_CREATE) -> {
                Log.d(APP_TAG, status)
                Log.d(APP_TAG, movieViewModel.getMovies().toString())

                movieViewModel.clearStatus()
                findNavController().popBackStack()
            }
        }
        }
    }

    companion object{
        const val APP_TAG = "APP TAG"
    }
}