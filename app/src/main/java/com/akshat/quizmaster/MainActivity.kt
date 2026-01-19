package com.example.quizzyquest

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var btnMaths: Button
    private lateinit var btnPhysics: Button
    private lateinit var btnChemistry: Button
    private lateinit var btnProgramming: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText)
        btnMaths = findViewById(R.id.btnMaths)
        btnPhysics = findViewById(R.id.btnPhysics)
        btnChemistry = findViewById(R.id.btnChemistry)
        btnProgramming = findViewById(R.id.btnProgramming)

        val categoryButtons = listOf(btnMaths, btnPhysics, btnChemistry, btnProgramming)

        // Disable category buttons initially
        categoryButtons.forEach { it.isEnabled = false }

        // Enable buttons only when a name is entered
        nameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val enable = s.toString().trim().isNotEmpty()
                categoryButtons.forEach { it.isEnabled = enable }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Handle category button clicks
        btnMaths.setOnClickListener { launchQuestionsActivity("Maths") }
        btnPhysics.setOnClickListener { launchQuestionsActivity("Physics") }
        btnChemistry.setOnClickListener { launchQuestionsActivity("Chemistry") }
        btnProgramming.setOnClickListener { launchQuestionsActivity("Programming") }
    }

    private fun launchQuestionsActivity(category: String) {
        val name = nameEditText.text.toString().trim()
        val intent = Intent(this, QuestionsActivity::class.java).apply {
            putExtra(KEY_USERNAME, name)
            putExtra(KEY_CATEGORY, category)
        }
        startActivity(intent)
        finish()
    }

    companion object {
        const val KEY_USERNAME = "USERNAME"
        const val KEY_CATEGORY = "CATEGORY"
    }
}
