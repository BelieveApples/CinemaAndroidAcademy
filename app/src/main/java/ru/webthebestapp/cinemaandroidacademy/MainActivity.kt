package ru.webthebestapp.cinemaandroidacademy

import android.graphics.Color
import android.graphics.Color.argb
import android.graphics.Color.rgb
import android.graphics.ColorSpace
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity(), FragmentClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.container, FragmentMoviesList())
                    .commit()
        }


    }

    override fun onReplaceFragmentClicked() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, FragmentMoviesDetails())
            .commit()
    }

    override fun onBackFragmentClicked() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, FragmentMoviesList())
            .commit()
    }
}

interface FragmentClickListener {
    fun onReplaceFragmentClicked()
    fun onBackFragmentClicked()
}