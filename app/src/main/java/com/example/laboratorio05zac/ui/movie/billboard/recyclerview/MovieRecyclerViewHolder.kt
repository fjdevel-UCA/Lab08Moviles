package com.example.laboratorio05zac.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05zac.data.model.MovieModel
import com.example.laboratorio05zac.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding:MovieItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bin(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }
}