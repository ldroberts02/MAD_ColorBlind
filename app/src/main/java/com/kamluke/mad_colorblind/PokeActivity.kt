package com.kamluke.mad_colorblind
/*
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import android.view.View
import android.graphics.Color
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.view.ViewCompat
import androidx.core.graphics.BlendModeCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class PokeActivity : AppCompatActivity() {
    private var leftNum :String = "Left"
    private var rightNum :String = "Submit"
    private var score :Int = 0
    var checkMode :Boolean = false;
    var currentPoke :Int = -1 //setting to -1 so it doesnt do anything unintended
    var currentSelection :String = ""
    var imageListVar = arrayOf(R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5,R.drawable.image_6,R.drawable.image_7,R.drawable.image_8,R.drawable.image_9,R.drawable.image_10,R.drawable.image_11,R.drawable.image_12,R.drawable.image_13,R.drawable.image_14,R.drawable.image_15,R.drawable.image_16,R.drawable.image_17,R.drawable.image_18,R.drawable.image_19,R.drawable.image_20,R.drawable.image_21,R.drawable.image_22,R.drawable.image_23,R.drawable.image_24,R.drawable.image_25,R.drawable.image_26,R.drawable.image_27,R.drawable.image_28,R.drawable.image_29,R.drawable.image_30)
    var nameListVar = arrayOf("Bulbasaur","Ivysaur","Venusaur","Charmander","Charmeleon","Charizard","Squirtle","Wartortle","Blastoise","Caterpie","Metapod","Butterfree","Weedle","Kakuna","Beedrill","Pidgey","Pidgeotto","Pidgeot","Rattata","Raticate","Spearow","Fearow","Ekans","Arbok","Pikachu","Raichu","Sandshrew","Sandslash","Nidoran","Nidorina")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // above init layout ui

        newImage()
        setScore(0)
    }

    fun radioButtonOnClick(view: View)
    {
        if (view.id == R.id.radioButton){
            currentSelection = findViewById<RadioButton>(R.id.radioButton).text.toString()
            findViewById<RadioGroup>(R.id.radioGroup).clearCheck()
        }

        if (view.id == R.id.radioButton2){
            currentSelection = findViewById<RadioButton>(R.id.radioButton2).text.toString()
            findViewById<RadioGroup>(R.id.radioGroup).clearCheck()
        }

        if (view.id == R.id.radioButton3){
            currentSelection = findViewById<RadioButton>(R.id.radioButton3).text.toString()
            findViewById<RadioGroup>(R.id.radioGroup2).clearCheck()
        }
        if (view.id == R.id.radioButton4){
        currentSelection = findViewById<RadioButton>(R.id.radioButton4).text.toString()
            findViewById<RadioGroup>(R.id.radioGroup2).clearCheck()
        }

        //findViewById<TextView>(R.id.score_text).text = currentSelection //how to set upper text

    }

    fun rightButtonOnClick(view: View)
    {
        if(checkMode)
        {
            newImage()
            checkMode = false;
            findViewById<RadioButton>(R.id.radioButton).setEnabled(true)
            findViewById<RadioButton>(R.id.radioButton2).setEnabled(true)
            findViewById<RadioButton>(R.id.radioButton3).setEnabled(true)
            findViewById<RadioButton>(R.id.radioButton4).setEnabled(true)
            findViewById<Button>(R.id.right_number_button).text = "Submit"
        }
        else if (!checkMode){
            if (currentSelection == nameListVar[currentPoke]) //if selection is correct
            {
                setScore(score + 1)
            }
            checkMode = true
            findViewById<ImageView>(R.id.imageView).drawable.colorFilter = null
            findViewById<RadioGroup>(R.id.radioGroup).clearCheck()
            findViewById<RadioGroup>(R.id.radioGroup2).clearCheck()
            findViewById<RadioButton>(R.id.radioButton).setEnabled(false)
            findViewById<RadioButton>(R.id.radioButton2).setEnabled(false)
            findViewById<RadioButton>(R.id.radioButton3).setEnabled(false)
            findViewById<RadioButton>(R.id.radioButton4).setEnabled(false)
            findViewById<Button>(R.id.right_number_button).text = "Next"


        }

    }

    fun setScore(_score: Int)
    {
        score = _score;

        // vari = (condition) ? true : false;

        //findViewById<ImageView>(R.id.you_won_image).visibility = if (score > 5) View.VISIBLE else View.INVISIBLE;

        findViewById<TextView>(R.id.score_text).text = "Score: $score"
    }
    fun newImage()
    {
        var rand = Random();
        var testInt :Int= rand.nextInt(25);
        Log.v("test",testInt.toString())
        currentPoke  = testInt;
        findViewById<ImageView>(R.id.imageView).setImageResource(imageListVar[testInt]);
        findViewById<ImageView>(R.id.imageView).drawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.BLACK, BlendModeCompat.SRC_ATOP)


        var randButton : Int = Random().nextInt(3)
        randButton += 1
        //R.drawable.image_1 is the parameters
        findViewById<RadioButton>(R.id.radioButton).text  = if (randButton == 1) nameListVar[testInt] else nameListVar[generateName(currentPoke)];
        findViewById<RadioButton>(R.id.radioButton2).text = if (randButton == 2) nameListVar[testInt] else nameListVar[generateName(currentPoke)];
        findViewById<RadioButton>(R.id.radioButton3).text = if (randButton == 3) nameListVar[testInt] else nameListVar[generateName(currentPoke)];
        findViewById<RadioButton>(R.id.radioButton4).text = if (randButton == 4) nameListVar[testInt] else nameListVar[generateName(currentPoke)];
    }
    fun generateName(pokeNum: Int): Int
    {
        var x :Int = Random().nextInt(nameListVar.count())
        return if (x == pokeNum) {
            if (x != 1) {
                x - 1
            } else {
                x + 1
            }
        } else {
            x
        }
    }
}*/