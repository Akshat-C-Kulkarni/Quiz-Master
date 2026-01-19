package com.example.quizzyquest

data class Question(
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: Int // 1-based index of correct answer
)
