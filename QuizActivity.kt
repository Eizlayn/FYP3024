package com.example.islamicbasics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var submitButton: Button
    private lateinit var question1Group: RadioGroup
    private lateinit var question2Group: RadioGroup
    private lateinit var question3Group: RadioGroup
    private lateinit var question4Group: RadioGroup
    private lateinit var question5Group: RadioGroup
    private lateinit var question6Group: RadioGroup
    private lateinit var question7Group: RadioGroup
    private lateinit var question8Group: RadioGroup
    private lateinit var question9Group: RadioGroup
    private lateinit var question10Group: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Initialize Views
        submitButton = findViewById(R.id.submitButton)

        question1Group = findViewById(R.id.question1Group)
        question2Group = findViewById(R.id.question2Group)
        question3Group = findViewById(R.id.question3Group)
        question4Group = findViewById(R.id.question4Group)
        question5Group = findViewById(R.id.question5Group)
        question6Group = findViewById(R.id.question6Group)
        question7Group = findViewById(R.id.question7Group)
        question8Group = findViewById(R.id.question8Group)
        question9Group = findViewById(R.id.question9Group)
        question10Group = findViewById(R.id.question10Group)

        // Initially disable submit button
        submitButton.isEnabled = false

        // Check if all questions are answered to enable submit button
        val radioGroups = listOf(
            question1Group, question2Group, question3Group, question4Group, question5Group,
            question6Group, question7Group, question8Group, question9Group, question10Group
        )

        radioGroups.forEach { group ->
            group.setOnCheckedChangeListener { _, _ ->
                submitButton.isEnabled = radioGroups.all { it.checkedRadioButtonId != -1 }
            }
        }

        // Handle Submit Button Click
        submitButton.setOnClickListener {
            val score = calculateScore()
            val answers = collectAnswers()

            // Pass the score and answers to the ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("score", score.toString())  // Pass score as a string
            intent.putStringArrayListExtra("answers", ArrayList(answers)) // Pass answers as ArrayList
            startActivity(intent)
        }
    }

    // Function to calculate the user's score
    private fun calculateScore(): Int {
        var score = 0

        // Check answers for each question and update score
        if (findViewById<RadioButton>(question1Group.checkedRadioButtonId).text == "B) Understanding and applying Islamic law") score++
        if (findViewById<RadioButton>(question2Group.checkedRadioButtonId).text == "D) Jihad") score++
        if (findViewById<RadioButton>(question3Group.checkedRadioButtonId).text == "B) Lordship") score++
        if (findViewById<RadioButton>(question4Group.checkedRadioButtonId).text == "C) Morality and ethics") score++
        if (findViewById<RadioButton>(question5Group.checkedRadioButtonId).text == "B) Fasting") score++
        if (findViewById<RadioButton>(question6Group.checkedRadioButtonId).text == "True") score++
        if (findViewById<RadioButton>(question7Group.checkedRadioButtonId).text == "True") score++
        if (findViewById<RadioButton>(question8Group.checkedRadioButtonId).text == "True") score++
        if (findViewById<RadioButton>(question9Group.checkedRadioButtonId).text == "True") score++
        if (findViewById<RadioButton>(question10Group.checkedRadioButtonId).text == "True") score++

        return score
    }

    // Function to collect the user's answers
    private fun collectAnswers(): List<String> {
        val answers = mutableListOf<String>()

        // Collect answers for each question
        answers.add(findViewById<RadioButton>(question1Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question2Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question3Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question4Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question5Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question6Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question7Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question8Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question9Group.checkedRadioButtonId).text.toString())
        answers.add(findViewById<RadioButton>(question10Group.checkedRadioButtonId).text.toString())

        return answers
    }
}
