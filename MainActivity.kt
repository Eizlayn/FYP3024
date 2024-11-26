package com.example.islamicbasics

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start Quiz Button
        val startQuizButton = findViewById<Button>(R.id.startQuizButton)
        startQuizButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        // View Lessons Button
        val viewLessonsButton = findViewById<Button>(R.id.viewLessonsButton)
        viewLessonsButton.setOnClickListener {
            val intent = Intent(this, LessonsActivity::class.java)
            startActivity(intent)
        }

        // User Manual Button
        val userManualButton = findViewById<Button>(R.id.userManualButton)
        userManualButton.setOnClickListener {
            openYouTubeVideo()
        }
    }

    // Function to open the YouTube video
    private fun openYouTubeVideo() {
        val youtubeUrl = "https://youtu.be/20qGeJg_5Y4?feature=shared" // Replace YOUR_VIDEO_ID with the actual YouTube video ID
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
        intent.resolveActivity(packageManager)?.let {
            startActivity(intent)
        }
    }
}
