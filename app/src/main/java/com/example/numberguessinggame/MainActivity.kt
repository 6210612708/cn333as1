package com.example.numberguessinggame

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var button: Button
    var count: Int = 0
    var cont: Boolean = true

    var random: Int = nextInt(1, 1000)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.buttonReset)

        textView.text = "Please enter your guess:"
        button.setOnClickListener {
            if (cont) {
                if (editText.text.isNotEmpty()) {
                    textView.setTextColor(Color.rgb(51,212,255))

                    val number: Int = editText.text.toString().toInt()
                    count++

                    if (number < random) {

                        textView.text = "wrong, your number is to low!"
                        editText.text.clear()

                    } else if (number > random) {

                        textView.text = "wrong, your number is to high!"
                        editText.text.clear()

                    } else {

                        textView.text = "Congratulation, your number is right! ,Your guessed is " + count + " times"
                        button.setText("Play again")
                        cont = false
                        editText.text.clear()

                    }
                } else {
                    textView.text = "Please fill your answer"
                    textView.setTextColor(Color.RED)
                }
        } else {
            reset()
            }
        }


    }
    fun reset() {
        random = nextInt(1, 1000)
        textView.text = "Please enter your guess :"
        button.setText("Submit")
        cont = true
        count = 0
        editText.text.clear()
    }
}