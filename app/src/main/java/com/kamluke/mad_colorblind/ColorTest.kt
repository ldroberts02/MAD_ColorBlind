package com.kamluke.mad_colorblind

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.util.Log
import android.view.View
import android.graphics.Color
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.Random
import androidx.core.view.WindowInsetsCompat
import org.checkerframework.checker.units.qual.Current

class ColorTest: AppCompatActivity() {

    public var currentSelection: String = ""
    private var score :Int = 0
    var currentProgress: Int = 1
    var maxProgress: Int = 15
    var amountCorrect: Int = 0
    var currentNumber: Int = 0
    var imageListVar = arrayOf(
        R.drawable.dark_1,
        R.drawable.dark_2,
        R.drawable.dark_3,
        R.drawable.dark_6,
        R.drawable.dark_7,
        R.drawable.dark_8,
        R.drawable.dark_9,
        R.drawable.light_1,
        R.drawable.light_2,
        R.drawable.light_3,
        R.drawable.light_4,
        R.drawable.light_5,
        R.drawable.light_6,
        R.drawable.light_7,
        R.drawable.light_8,
        R.drawable.light_9,
        R.drawable.med_3,
        R.drawable.med_4,
        R.drawable.med_5,
        R.drawable.med_7
    )
    var numberListVar = arrayOf(
        "1",
        "2",
        "3",
        "6",
        "7",
        "8",
        "9",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "3",
        "4",
        "5",
        "7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.analyze)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.colorTestLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<TextView>(R.id.progressText).text =
            "Progress: $currentProgress of $maxProgress and $score"

        newImage()
        findViewById<Button>(R.id.button3).setEnabled(false)

    }


        fun radioButtonOnClick(view:View )
        {
            if (view.id == R.id.radioButton){
                currentSelection = findViewById<RadioButton>(R.id.radioButton).text.toString()
                //findViewById<RadioGroup>(R.id.radioGroup).clearCheck()
            }

            if (view.id == R.id.radioButton2){
                currentSelection = findViewById<RadioButton>(R.id.radioButton2).text.toString()
                //findViewById<RadioGroup>(R.id.radioGroup).clearCheck()
            }

            if (view.id == R.id.radioButton3){
                currentSelection = findViewById<RadioButton>(R.id.radioButton3).text.toString()
                //findViewById<RadioGroup>(R.id.radioGroup).clearCheck()
            }
            if (view.id == R.id.radioButton4){
                currentSelection = findViewById<RadioButton>(R.id.radioButton4).text.toString()
                //findViewById<RadioGroup>(R.id.radioGroup).clearCheck()
            }
            findViewById<Button>(R.id.button3).setEnabled(true)
        }

        fun generateName(pokeNum: Int): Int
        {
            var x :Int = Random().nextInt(numberListVar.count())
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
        fun newImage()
        {
            var rand = Random();
            var testInt :Int= rand.nextInt(20);
            Log.v("test",testInt.toString())
            currentNumber  = testInt; //set the number in hud
            findViewById<ImageView>(R.id.testingImage).setImageResource(imageListVar[testInt]);


            var randButton : Int = Random().nextInt(3)
            randButton += 1
            //R.drawable.image_1 is the parameters
            findViewById<RadioButton>(R.id.radioButton).text  = if (randButton == 1) numberListVar[testInt] else numberListVar[generateName(currentNumber)];
            findViewById<RadioButton>(R.id.radioButton2).text = if (randButton == 2) numberListVar[testInt] else numberListVar[generateName(currentNumber)];
            findViewById<RadioButton>(R.id.radioButton3).text = if (randButton == 3) numberListVar[testInt] else numberListVar[generateName(currentNumber)];
            findViewById<RadioButton>(R.id.radioButton4).text = if (randButton == 4) numberListVar[testInt] else numberListVar[generateName(currentNumber)];
        }

        fun rightButtonOnClick(view: View)
        {
            currentProgress += 1
            if (currentSelection.toString() == numberListVar[currentNumber].toString()) //if selection is correct
            {
                setScore(score + 1)
            }
            if (currentProgress >= maxProgress + 1) {

                val intent = Intent(this@ColorTest, Statistics::class.java)
                startActivity(intent)
            }




            newImage()
            findViewById<RadioGroup>(R.id.radioGroup).clearCheck()
            findViewById<RadioButton>(R.id.radioButton).setEnabled(true)
            findViewById<RadioButton>(R.id.radioButton2).setEnabled(true)
            findViewById<RadioButton>(R.id.radioButton3).setEnabled(true)
            findViewById<RadioButton>(R.id.radioButton4).setEnabled(true)

            findViewById<Button>(R.id.button3).setEnabled(false)
            findViewById<TextView>(R.id.progressText).text =
                "Progress: $currentProgress of $maxProgress and $score"

        }
    fun setScore(_score: Int)
    {
        score = _score;

        // vari = (condition) ? true : false;

        //findViewById<ImageView>(R.id.you_won_image).visibility = if (score > 5) View.VISIBLE else View.INVISIBLE;

        //findViewById<TextView>(R.id.score_text).text = "Score: $score"
    }
}



