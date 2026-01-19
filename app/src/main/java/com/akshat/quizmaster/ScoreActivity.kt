package com.akshat.quizmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private lateinit var congratulationsTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var playAgainButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // Get values from intent
        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        val name = intent.getStringExtra("name") ?: "User"
        val category = intent.getStringExtra("category") ?: "General"

        // Initialize views
        congratulationsTextView = findViewById(R.id.congratulationsTextView)
        scoreTextView = findViewById(R.id.scoreTextView)
        playAgainButton = findViewById(R.id.playAgainButton)

        // Set data to views
        congratulationsTextView.text = "Congratulations, $name!"
        scoreTextView.text = "You scored $score out of $total in $category."

        // Play again
        playAgainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
