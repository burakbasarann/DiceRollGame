package com.example.dicerollgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtskor=findViewById<TextView>(R.id.txtskor)
        val txtsonuc=findViewById<TextView>(R.id.txtzarsonuc)
        val txtinputlayout=findViewById<TextInputLayout>(R.id.textInputLayout)
        val txtedit=findViewById<TextInputEditText>(R.id.textInputEditText)
        val imgdice=findViewById<ImageView>(R.id.imgdice)
        val btndiceroll=findViewById<Button>(R.id.btnDiceRoll)
        var diceroll= 1..6
        var skor=100

        btndiceroll.setOnClickListener {
            var dicerollrndm=diceroll.random()
            when(dicerollrndm){
                1-> imgdice.setImageResource(R.drawable.dice_1)
                2-> imgdice.setImageResource(R.drawable.dice_2)
                3-> imgdice.setImageResource(R.drawable.dice_3)
                4-> imgdice.setImageResource(R.drawable.dice_4)
                5-> imgdice.setImageResource(R.drawable.dice_5)
                6-> imgdice.setImageResource(R.drawable.dice_6)
            }
            txtsonuc.visibility=View.VISIBLE
            txtsonuc.setText("Atılan Zar : ${dicerollrndm}")


            if(txtedit.text.toString().trim().isEmpty()){
                txtskor.setText("Sayı Girmedin Dostum")
            }
            else {
                if (txtedit.text.toString().toInt()==dicerollrndm)
                {
                    skor=skor+120
                    txtskor.setText("Skorun : ${skor}")
                }
                else{
                    skor=skor-20
                    txtskor.setText("Skorun : ${skor}")
                }
            }

            if(skor==0){
                val i = Intent(this,KaybettinActivity::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }

        val btnzartahmin=findViewById<Button>(R.id.btnzartahmin)

        btnzartahmin.setOnClickListener {

            btnzartahmin.visibility= View.GONE
            txtinputlayout.visibility=View.VISIBLE

            txtskor.visibility=View.VISIBLE
            txtskor.setText("100 Skor ile Başlarsın \n Doğru Bildiğinde 120 Puan Kazanırsın \n Yanlış Bildiğinde 20 Puanın Eksilir")

        }


    }


}