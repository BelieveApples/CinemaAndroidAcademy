package ru.webthebestapp.cinemaandroidacademy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentMoviesList  : Fragment(){
private var fragmentClickListener: FragmentClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.view_holder_movie, container, false)

        view?.findViewById<ImageView>(R.id.movie1)?.apply {
            setOnClickListener{
                fragmentClickListener?.onReplaceFragmentClicked()
            }
        }

        return view
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

    companion object {
        fun newInstance() : FragmentMoviesList {
            val fragment = FragmentMoviesList()
            return fragment
        }
    }

}