package ru.webthebestapp.cinemaandroidacademy

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)

        view?.findViewById<TextView>(R.id.tv_back)?.apply {
            setOnClickListener {
                fragmentClickListener?.onBackFragmentClicked()
            }
        }
        view?.findViewById<ImageView>(R.id.iv_back)?.apply {
            setOnClickListener {
                fragmentClickListener?.onBackFragmentClicked()
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
        fun newInstance() : FragmentMoviesDetails {
            val fragment = FragmentMoviesDetails()
            return fragment
        }
    }
}