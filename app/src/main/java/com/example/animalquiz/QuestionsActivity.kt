package com.example.animalquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var CurrentPosition: Int = 1
    private var QuestionList: ArrayList<Questions>? = null
    private var SelectedOptionPosition: Int = 0
    private var CorrectAnswers: Int = 0
    private var UserName: String? = null


    private var optionOne:TextView? = null
    private var optionTwo:TextView? = null
    private var optionThree:TextView? = null
    private var optionFour:TextView? = null
    private var buttonSubmit:Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)



        optionOne = findViewById(R.id.qa_option_one)
        optionTwo = findViewById(R.id.qa_option_two)
        optionThree = findViewById(R.id.qa_option_three)
        optionFour = findViewById(R.id.qa_option_four)
        buttonSubmit = findViewById(R.id.qa_submit)


        UserName = intent.getStringExtra(Constants.USER_NAME)

        QuestionList = Constants.getQuestions()

        setQuestion()

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)




    }

    private fun setQuestion(){

        val question = QuestionList!![CurrentPosition - 1]

        defaultLook()

        if (CurrentPosition == QuestionList!!.size){
            buttonSubmit?.text = "FINISH"
        }else{
            buttonSubmit?.text = "SUBMIT"
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = CurrentPosition

        val progress = findViewById<TextView>(R.id.tv_progress)
        progress.text = "$CurrentPosition" + "/" + progressBar.max

        val askedQuestion = findViewById<TextView>(R.id.tv_question)
        askedQuestion.text = question!!.question

        val image = findViewById<ImageView>(R.id.iv_image)
        image.setImageResource(question.image)

        val optionOne = findViewById<TextView>(R.id.qa_option_one)
        val optionTwo = findViewById<TextView>(R.id.qa_option_two)
        val optionThree = findViewById<TextView>(R.id.qa_option_three)
        val optionFour = findViewById<TextView>(R.id.qa_option_four)

        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour
    }

    private fun defaultLook(){
        val option = ArrayList<TextView>()
        optionOne?.let { option.add(0, it) }
        optionTwo?.let { option.add(1, it) }
        optionThree?.let { option.add(2, it) }
        optionFour?.let { option.add(3, it) }

        for (option in option){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_background)
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.qa_option_one -> { optionOne?.let { selectedOption(it, 1) }
            }
            R.id.qa_option_two -> { optionTwo?.let { selectedOption(it, 2) }
            }
            R.id.qa_option_three->{ optionThree?.let{ selectedOption(it, 3) }
            }
            R.id.qa_option_four->{ optionFour?.let{ selectedOption(it, 4) }
            }
            R.id.qa_submit->{
                if (SelectedOptionPosition == 0){
                    CurrentPosition++
                    when{
                        CurrentPosition <= QuestionList!!.size ->{
                            setQuestion()
                        }else->{
                            val intent = Intent(this, ScoreActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, UserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, CorrectAnswers)
                            intent.putExtra(Constants.ALL_QUESTIONS, QuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = QuestionList?.get(CurrentPosition - 1)
                    if (question!!.correctAnswer != SelectedOptionPosition){
                        answer(SelectedOptionPosition, R.drawable.wrong_option_background)
                    }else{
                        CorrectAnswers++
                    }
                    answer(question.correctAnswer, R.drawable.correct_option_background)
                    if (CurrentPosition == QuestionList!!.size){
                        buttonSubmit?.text = "FINISH"
                    }else{
                        buttonSubmit?.text = "NEXT QUESTION"
                    }
                    SelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answer(answer: Int, drawableV: Int){
        when(answer){
            1->{
                optionOne?.background = ContextCompat.getDrawable(this, drawableV)
            }
            2->{
                optionTwo?.background = ContextCompat.getDrawable(this, drawableV)
            }
            3->{
                optionThree?.background = ContextCompat.getDrawable(this, drawableV)
            }
            4->{
                optionFour?.background = ContextCompat.getDrawable(this, drawableV)
            }
        }
    }

    private fun selectedOption(textView: TextView, selectedOption: Int){
        defaultLook()
        SelectedOptionPosition = selectedOption

        textView.setTextColor(Color.parseColor("#363a43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_background_bg)
    }
}

























