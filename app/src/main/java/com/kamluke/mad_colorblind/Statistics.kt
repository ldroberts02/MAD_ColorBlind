package com.kamluke.mad_colorblind



import android.content.Context
import android.content.Intent
import org.json.JSONArray
import org.json.JSONObject
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
data class ScoreEntry(val username: String, val score: Int)

class Statistics: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.leaderboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.leaderboard)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val button = findViewById<Button>(R.id.returnButton)
        button.setOnClickListener {
            val intent = Intent(this@Statistics, ColorTest::class.java)
            startActivity(intent)
        }

        LeaderboardStorage.saveScore(this, ScoreEntry("Player1", 200))
        val score = LeaderboardStorage.loadLeaderboard(this)
        for (entry in score) {
            Log.d("Leaderboard", "${entry.username}: ${entry.score}")
        }
    }
}

object LeaderboardStorage{
    private const val PrefsName : String = "leaderboard_prefs"
    private const val KeyLeaderboard : String = "leaderboard"

    fun saveScore(context: Context, entry: ScoreEntry) {
        val prefs = context.getSharedPreferences(PrefsName, Context.MODE_PRIVATE)
        val jsonString = prefs.getString(KeyLeaderboard, "[]")
        val jsonArray = JSONArray(jsonString)

        val newEntry = JSONObject().apply {
            put("username", entry.username)
            put("score",entry.score)
        }
        jsonArray.put(newEntry)

        val sortedList = (0 until jsonArray.length()).map {jsonArray.getJSONObject(it)}.sortedByDescending { it.getInt("score") }

        val sortedArray = JSONArray()
        for(obj in sortedList)
            prefs.edit().putString(KeyLeaderboard, sortedArray.toString()).apply() }
    fun loadLeaderboard(context: Context): List<ScoreEntry>{
        val prefs = context.getSharedPreferences(PrefsName, Context.MODE_PRIVATE)
        val jsonString = prefs.getString(KeyLeaderboard, "[]")
        val jsonArray = JSONArray(jsonString)

        val list = mutableListOf<ScoreEntry>()
        for(i in 0 until jsonArray.length()){
            val obj = jsonArray.getJSONObject(i)
            list.add(ScoreEntry(obj.getString("username"), obj.getInt("score")))
        }
        return list
    }
}



