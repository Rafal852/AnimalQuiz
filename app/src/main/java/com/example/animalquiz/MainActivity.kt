package com.example.animalquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val Start = findViewById<Button>(R.id.am_start)
        val userName = findViewById<EditText>(R.id.am_name)
        Start.setOnClickListener {
            if (userName.text.toString().isEmpty()){
                Toast.makeText(this, "You have to enter your name.", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, userName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}