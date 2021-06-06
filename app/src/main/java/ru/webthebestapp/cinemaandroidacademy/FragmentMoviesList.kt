package ru.webthebestapp.cinemaandroidacademy

import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class FragmentMoviesList  : Fragment() {
private var fragmentClickListener: FragmentClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)

        val movies = generatesMovies()
        val list = view?.findViewById<RecyclerView>(R.id.rv_movie)
        val adapter = MovieAdapter(clickListener, movies)
        list?.adapter = adapter
        list?.layoutManager = GridLayoutManager(context, 2)

        val textView: TextView? = view?.findViewById(R.id.cast)

        val shader: Shader = LinearGradient(0f,0f,200f,20f,
                intArrayOf(Color.rgb(236, 236, 236), Color.rgb(196,196,196), Color.rgb(255,255,255)),
                null,
        Shader.TileMode.CLAMP)
        textView?.paint?.shader = shader

        return view
    }

    fun generatesMovies(): List<Movie> {
        return listOf(
            Movie("1", "Avengers", "13","111 reviews", "123 min"),
            Movie("2", "Avengerqwds", "13","111 reviews", "123 min"),
            Movie("1", "Avengdqwers", "13","111 reviews", "123 min"),
            Movie("2", "Avengerdqws", "13","111 reviews", "123 min")
            )
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentClickListener) {
            fragmentClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentClickListener = null
    }

    private fun doOnClick(movie: Movie) {
        movie.apply {
            fragmentClickListener?.onReplaceFragmentClicked()
        }
    }

    private val clickListener = object : onReplaceFragment {
        override fun onClick(movie: Movie) {
            doOnClick(movie)
        }
    }

    companion object {
        fun newInstance() : FragmentMoviesList {
            val fragment = FragmentMoviesList()
            return fragment
        }
    }

}

