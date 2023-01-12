package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import java.util.logging.Handler

class Splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

             android.os.Handler().postDelayed({movetonextactivity()}, 3000)

    }

    private fun movetonextactivity() {
    startActivity(Intent(this , MainActivity::class.java))
        finish()
    }


}