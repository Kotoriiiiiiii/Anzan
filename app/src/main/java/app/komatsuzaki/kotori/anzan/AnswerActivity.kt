package app.komatsuzaki.kotori.anzan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.komatsuzaki.kotori.anzan.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {

    // バインディングクラスの変数
    private lateinit var binding: ActivityAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnswerBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        //　クイズ画面から問題を受け取る
        val displayQuestion = intent.getStringExtra("question")
        // クイズ画面から入力された数字を受け取る
        val yourAnswer = intent.getStringExtra("answer")
        // クイズ画面から正解の数字を受け取る
        val correctAnswer = intent.getStringExtra("correct")

        // 問題をTextViewに反映する
        binding.questionText.text = displayQuestion
        // 入力された数字をTextViewに反映する
        binding.yourAnswerText.text = yourAnswer

        //　入力された数字と正解の数字を比べて
        if (yourAnswer == correctAnswer) {
            // 正解の場合は、正解の画像をImageViewに反映する
            binding.markImage.setImageResource(R.drawable.correct_image)
            // 正解の場合は、正解の画像をImageViewに反映する
            binding.randyImage.setImageResource(R.drawable.randy_happy_image)
        } else {
            // 不正解の場合は不正解のImageView挿入
            binding.markImage.setImageResource(R.drawable.miss_image)
            //同様
            binding.randyImage.setImageResource(R.drawable.randy_sad_image)
        }

        //　戻るタップの時
        binding.backButton.setOnClickListener {
            //　クイズ画面を表示する画面に情報を送る変数を準備する
            val questionPage = Intent(this, MainActivity::class.java)
            //クイズ画面を起動する
            startActivity(questionPage)
            // 答え合わせ画面を閉じる
            finish()
        }
    }
}