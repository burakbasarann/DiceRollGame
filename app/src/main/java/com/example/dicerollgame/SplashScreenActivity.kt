package com.example.dicerollgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

       splashscreenLogo()
    }

    fun splashscreenLogo(){
        val imgsplashscreen = findViewById<ImageView>(R.id.imgsplashscreen)

        imgsplashscreen.alpha = 0f
        imgsplashscreen.animate().setDuration(2500).alpha(1f).withEndAction {
            val i = Intent(this, MainActivity::class.java)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(i)
            finish()
        }
    }
}