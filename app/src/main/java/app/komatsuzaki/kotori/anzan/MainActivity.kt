package app.komatsuzaki.kotori.anzan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.komatsuzaki.kotori.anzan.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply{ setContentView(this.root) }

        val randomNumber1 = Random.nextInt(1000)
        val randomNumber2 = Random.nextInt(1000)

        binding.number1Text.text = randomNumber1.toString()
        binding.number2Text.text = randomNumber2.toString()

        val randomOperator = Random.nextInt(2)

        var operatorText = ""

        var correctAnswer = 0

        if(randomOperator == 0) {
            operatorText = " + "

            binding.signText.text = operatorText

            correctAnswer = randomNumber1 + randomNumber2

        } else {
            operatorText = " - "

            binding.signText.text = operatorText

            correctAnswer = randomNumber1 - randomNumber2

        }

        binding.checkButton.setOnClickListener {
            val yourAnswer = binding.inputText.text.toString()

            if (yourAnswer.isNotEmpty()) {
                // 正解・不正解を表示する画面に情報を送る変数を準備する
                val answerPage = Intent(this, AnswerActivity::class.java)

                val questionText =
                    randomNumber1.toString() + operatorText + randomNumber2.toString() + "="
                // 問題をセットする
                answerPage.putExtra("question", questionText)
                // 入力された数字をセットする
                answerPage.putExtra("answer", yourAnswer)
                // 正しい答えをセットする
                answerPage.putExtra("correct", correctAnswer.toString())

                startActivity(answerPage)

                finish()
            }
        }
    }
}