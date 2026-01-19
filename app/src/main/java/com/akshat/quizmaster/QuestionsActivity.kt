package com.example.quizzyquest

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvNameCategory: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var btnNext: Button
    private lateinit var optionButtons: List<Button>

    private lateinit var userName: String
    private lateinit var category: String
    private lateinit var questionsList: List<Question>

    private var currentPosition = 0
    private var selectedOption = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        tvNameCategory = findViewById(R.id.tvNameCategory)
        tvQuestion = findViewById(R.id.tvQuestion)
        btnNext = findViewById(R.id.btnNext)

        optionButtons = listOf(
            findViewById(R.id.btnOption1),
            findViewById(R.id.btnOption2),
            findViewById(R.id.btnOption3),
            findViewById(R.id.btnOption4)
        )

        userName = intent.getStringExtra("USERNAME") ?: ""
        category = intent.getStringExtra("CATEGORY") ?: ""

        tvNameCategory.text = "$userName - $category Quiz"

        questionsList = getQuestionsByCategory(category)

        setQuestion()

        optionButtons.forEachIndexed { index, button ->
            button.setOnClickListener(this)
        }

        btnNext.setOnClickListener {
            if (!answered) {
                Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
            } else {
                currentPosition++
                if (currentPosition < questionsList.size) {
                    setQuestion()
                } else {
                    // Redirect to score page
                    val intent = Intent(this, ScoreActivity::class.java)
                    intent.putExtra("USERNAME", userName)
                    intent.putExtra("SCORE", score)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun setQuestion() {
        val question = questionsList[currentPosition]
        resetOptions()

        tvQuestion.text = question.question
        optionButtons[0].text = question.option1
        optionButtons[1].text = question.option2
        optionButtons[2].text = question.option3
        optionButtons[3].text = question.option4

        btnNext.text = if (currentPosition == questionsList.size - 1) "Submit" else "Next"
        answered = false
        selectedOption = 0
    }

    private fun resetOptions() {
        for (button in optionButtons) {
            button.background = ContextCompat.getDrawable(this, R.drawable.default_option)
            button.isEnabled = true
        }
    }

    override fun onClick(v: View?) {
        if (answered) return

        val selectedBtn = v as Button
        selectedOption = optionButtons.indexOf(selectedBtn) + 1
        val correctAnswer = questionsList[currentPosition].correctAnswer

        answered = true

        if (selectedOption == correctAnswer) {
            selectedBtn.background = ContextCompat.getDrawable(this, R.drawable.correct_answer)
            score++
        } else {
            selectedBtn.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer)
            optionButtons[correctAnswer - 1].background =
                ContextCompat.getDrawable(this, R.drawable.correct_answer)
        }

        // Disable all options after answering
        optionButtons.forEach { it.isEnabled = false }
    }

    private fun getQuestionsByCategory(category: String): List<Question> {
        return when (category) {
            "Maths" -> listOf(
                Question("5 + 3 = ?", "6", "7", "8", "9", 3),
                Question("10 - 6 = ?", "3", "4", "5", "2", 2)
            )
            "Physics" -> listOf(
                Question("Speed = ?", "Mass/Time", "Distance/Time", "Force/Area", "Work/Time", 2),
                Question("Unit of Force?", "Newton", "Joule", "Pascal", "Watt", 1)
            )
            "Chemistry" -> listOf(
                Question("Water formula?", "CO2", "H2O", "O2", "NaCl", 2),
                Question("Symbol of Sodium?", "S", "Na", "Sn", "So", 2)
            )
            "Programming" -> listOf(
                Question("Which is not a language?", "Java", "Python", "HTML", "Elephant", 4),
                Question("Which is a backend language?", "CSS", "JavaScript", "PHP", "XML", 3)
            )
            else -> emptyList()
        }
    }
}
