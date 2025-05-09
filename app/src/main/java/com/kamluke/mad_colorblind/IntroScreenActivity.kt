package com.kamluke.mad_colorblind

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject


class IntroScreenActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.intro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.IntroLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun loginButtonOnClick(view: View) //for the button in intro.xml
    {
        val intent = Intent(this@IntroScreenActivity, ColorTest::class.java) //load colorTest.kt into variable
        startActivity(intent)
    }


}