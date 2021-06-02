package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constellcardView = findViewById<CardView>(R.id.constellationcard)
        val namecardView = findViewById<CardView>(R.id.namecard)
        val randomcardView = findViewById<CardView>(R.id.randomcard)

        constellcardView.setOnClickListener{
            startActivity(Intent(this, ConstellationActivity::class.java))
        }
        namecardView.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
        randomcardView.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            startActivity(intent)
        }
    }
}

fun getRandomLottoNumber(): Int{
    return Random().nextInt(45)+1
}

fun getRandomLottoNumbers(): MutableList<Int> {
    val lottoNumbers = mutableListOf<Int>()

    while (true) {
        val number = getRandomLottoNumber()
        var flag_exist = 0

        if (lottoNumbers.size < 1) {
            lottoNumbers.add(number)
            continue
        } else {
            for (j in 0 until lottoNumbers.size) {
                if (number == lottoNumbers[j]) {
                    flag_exist = 1
                    break
                }
            }
            if (flag_exist == 0)
                lottoNumbers.add(number)
            if (lottoNumbers.size >= 6)
                break
        }
    }
    return lottoNumbers
}

fun getShuffledLottoNumbers () : MutableList<Int> {
    val lottoNumbers = mutableListOf<Int>()

    for (number in 1..45) {
        lottoNumbers.add(number)
    }
    lottoNumbers.shuffle()
    return lottoNumbers.subList(0, 6)
}