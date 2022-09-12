package com.example.worldle4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class MainActivity : AppCompatActivity() {


    var wordToGuess = FourLetterWordList.getRandomFourLetterWord()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var count = 0

        var playerGuess = findViewById<Button>(R.id.button_guess)

        var textA = findViewById<TextView>(R.id.TextA)
        var textAc = findViewById<TextView>(R.id.TextAc)
        var textB = findViewById<TextView>(R.id.TextB)
        var textBc = findViewById<TextView>(R.id.TextBc)
        var textC = findViewById<TextView>(R.id.TextC)
        var textCc = findViewById<TextView>(R.id.TextCc)
        var correct = findViewById<TextView>(R.id.Correct)

        correct.apply { text = wordToGuess }
        correct.visibility = View.GONE


        playerGuess.setOnClickListener {
            var playerInput = findViewById<EditText>(R.id.guess)
            var right: String
            var firstWord = ""
            var secondWord = ""
            var thirdWord = ""
            count++

            if (count == 1) {
                firstWord = playerInput.text.toString().uppercase()
                right = wordToGuess.checkGuess(firstWord)
                textA.apply { text = firstWord }
                textAc.apply { text = right }
            } else if (count == 2) {
                secondWord = playerInput.text.toString().uppercase()
                right = wordToGuess.checkGuess(secondWord)
                textB.apply { text = secondWord }
                textBc.apply { text = right }

            } else if (count == 3) {
                thirdWord = playerInput.text.toString().uppercase()
                right = wordToGuess.checkGuess(thirdWord)
                textC.apply { text = thirdWord }
                textCc.apply { text = right }

            } else {

                correct.visibility = View.VISIBLE
                Log.i("counter", "Sorry!")
            }


        }







            /**
             * Parameters / Fields:
             *   wordToGuess : String - the target word the user is trying to guess
             *   guess : String - what the user entered as their guess
             *
             * Returns a String of 'O', '+', and 'X', where:
             *   'O' represents the right letter in the right place
             *   '+' represents the right letter in the wrong place
             *   'X' represents a letter not in the target word
             */





        }

    private fun Any.checkGuess(guess: String): String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            } else if (guess[i] in wordToGuess) {
                result += "+"
            } else {
                result += "X"
            }
        }
        return result
    }


}


