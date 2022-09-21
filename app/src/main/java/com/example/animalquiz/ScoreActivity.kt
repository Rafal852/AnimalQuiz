package com.example.animalquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val userName = intent.getStringExtra(Constants.USER_NAME)

        val score = findViewById<TextView>(R.id.sa_score)
        val finishName = findViewById<TextView>(R.id.sa_name)
        val buttonFinish = findViewById<Button>(R.id.sa_finish)

        finishName.text = userName

        val allQuestions = intent.getIntExtra(Constants.ALL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        score.text = "Hey! You scored $correctAnswers out of $allQuestions!"

        buttonFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}