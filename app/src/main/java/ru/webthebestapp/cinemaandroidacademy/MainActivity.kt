package ru.webthebestapp.cinemaandroidacademy

import android.graphics.Color
import android.graphics.Color.argb
import android.graphics.Color.rgb
import android.graphics.ColorSpace
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movies_list)

//        val textView: TextView = findViewById(R.id.cast)
//
//        val shader: Shader = LinearGradient(0f,0f,200f,20f,
//                intArrayOf(Color.rgb(236, 236, 236), Color.rgb(196,196,196), Color.rgb(255,255,255)),
//                null,
//        Shader.TileMode.CLAMP)
//        textView.paint.setShader(shader)
    }
}