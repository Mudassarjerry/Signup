package com.example.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.btn

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val f_name = intent.getStringExtra(("FirstName"))
        val password = intent.getStringExtra("Password")

        btn.setOnClickListener() {



         luck()

        }




    }

    private fun luck() {
        if(fname() && ps() ){
            Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fname() : Boolean {
         val fn = f_name.text.toString()
        if(fn.isEmpty()){
            f_name.error = "Required"
            return false
        }


            else{
                return true
            }}


            private fun ps() : Boolean {
                val ps = password.text.toString()
                if(ps.isEmpty()){
                    password.error = "Required"
                    return false
                }


                    else{
                        return true
                    }


        }


    }
