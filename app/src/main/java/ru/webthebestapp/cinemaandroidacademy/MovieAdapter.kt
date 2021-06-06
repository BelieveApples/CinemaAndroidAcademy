package ru.webthebestapp.cinemaandroidacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(
    private val clickListener: onReplaceFragment,
    val movies: List<Movie>
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(
            parent.context
        ).inflate(R.layout.view_holder_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.findViewById<ImageView>(R.id.movie).setOnClickListener {
            clickListener.onClick(movies[position])
        }
    }

    override fun getItemCount(): Int = movies.size

    fun getItem(position: Int): Movie = movies[position]
}

interface onReplaceFragment {
    fun onClick(movie: Movie)
}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageMovie: ImageView = itemView.findViewById(R.id.movie)
    private val name: TextView = itemView.findViewById(R.id.name)
    private val tag: TextView = itemView.findViewById(R.id.tag)
    private val reviews: TextView = itemView.findViewById(R.id.tv_reviews)
    private val min: TextView = itemView.findViewById(R.id.min)

    fun bind(movie: Movie) {
        if (movie.imageMovie == "1") {
            imageMovie.setImageResource(R.drawable.movie1)
        } else {
            imageMovie.setImageResource(R.drawable.movie2)
        }

        name.text = movie.name
        tag.text = movie.tag
        reviews.text = movie.reviews
        min.text = movie.min
    }
}