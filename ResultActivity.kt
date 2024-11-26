package com.example.islamicbasics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private lateinit var answersLayout: TextView
    private lateinit var retakeButton: Button
    private lateinit var finishButton: Button
    private lateinit var score: String
    private lateinit var answers: List<String>

    // List of full questions
    private val questions = listOf(
        "1. What is Feqah?",
        "2. Which of the following is NOT one of the Five Pillars of Islam?",
        "3. Tauhid al-Rububiyyah refers to the oneness of Allah in what aspect?",
        "4. What is Akhlak primarily concerned with?",
        "5. What is an example of Ibadat in Islam?",
        "6. Tauhid is the concept of oneness of Allah in Islam.",
        "7. Akhlak refers to the moral character in Islam.",
        "8. Feqah refers to the understanding of Islamic jurisprudence.",
        "9. Jihad is one of the Five Pillars of Islam.",
        "10. Salat (prayer) is obligatory for every Muslim."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Get data from Intent
        score = intent.getStringExtra("score") ?: "0/10"
        answers = intent.getStringArrayListExtra("answers") ?: emptyList()

        // Initialize Views
        resultText = findViewById(R.id.resultText)
        answersLayout = findViewById(R.id.answersLayout)
        retakeButton = findViewById(R.id.retakeButton)
        finishButton = findViewById(R.id.finishButton)

        // Display score
        resultText.text = "Your Score: $score/10"

        // Display questions with answers and correct/wrong marks
        var displayAnswers = ""
        val correctAnswers = listOf(
            "B) Understanding and applying Islamic law",
            "D) Jihad",
            "B) Lordship",
            "C) Morality and ethics",
            "B) Fasting",
            "True",
            "True",
            "True",
            "True",
            "True"
        )

        for (i in answers.indices) {
            val userAnswer = answers[i]
            val correctAnswer = correctAnswers[i]
            val question = questions[i]

            displayAnswers += "$question\n"

            if (userAnswer == correctAnswer) {
                displayAnswers += "Your Answer: $userAnswer ✔️\n\n"
            } else {
                displayAnswers += "Your Answer: $userAnswer ❌\n(Correct: $correctAnswer)\n\n"
            }
        }

        answersLayout.text = displayAnswers

        // Handle Retake Button
        retakeButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java) // Replace with actual quiz activity class
            startActivity(intent)
            finish()
        }

        // Handle Finish Button
        finishButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Replace with actual main activity class
            startActivity(intent)
            finish()
        }
    }
}
