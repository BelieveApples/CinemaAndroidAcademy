package ru.webthebestapp.cinemaandroidacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorAdapter(val actors: List<Actor>) : RecyclerView.Adapter<ActorMovieHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorMovieHolder {
        return ActorMovieHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_actor, parent, false))
    }

    override fun onBindViewHolder(holder: ActorMovieHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = actors.size

    fun getItem(position: Int): Actor = actors[position]
}

class ActorMovieHolder(view: View): RecyclerView.ViewHolder(view) {
    private val actorImage: ImageView = itemView.findViewById(R.id.iv_actor)
    private val name: TextView = itemView.findViewById(R.id.tv_actor)

    fun bind(actor: Actor) {
        when (actor.actorImage) {
            "robert" -> {
                actorImage.setImageResource(R.drawable.movie_robert)
            }
            "thor" -> {
                actorImage.setImageResource(R.drawable.movie_thor)
            }
            "mark" -> {
                actorImage.setImageResource(R.drawable.movie_mark)
            }
            else -> {
                actorImage.setImageResource(R.drawable.movie_chris)
            }
        }

        name.text = actor.name

    }
}