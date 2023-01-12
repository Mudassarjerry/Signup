package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val address = findViewById<EditText>(R.id.address)
        val phone = findViewById<EditText>(R.id.phone)
        val pass = findViewById<EditText>(R.id.pass)
       val check = findViewById<CheckBox>(R.id.checkbox)
        val sign = findViewById<Button>(R.id.btn)

        sign.setOnClickListener() {

           ValidateUserDetails()

        }
    }



    private fun ValidateUserDetails( ) {

          if(validateName() && validateEmail() && validateAddress() && validatePhone()  && validatePass() && validatecheckbox()){

             Nextactivity()



          }
    }

    private fun Nextactivity() {
        val n = name.text.toString()
        val pas = pass.text.toString()
       val  intent = Intent(this , login::class.java)
        intent.putExtra("Name",n)
        intent.putExtra("Password" ,pas)
        startActivity(intent)

    }


    private fun validateName(): Boolean {
        val n = name.text.toString()
        if(n.isEmpty()) {
            name.error = "Required"
            return false
        }
        else
            {
            var regexforname = Pattern.compile("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+")
            if (!regexforname.matcher(n).matches()) {
                name.error = "Correct name"
                return false
            }
            else {
                return true
            }

        }

        }



    private fun validateEmail(): Boolean {
        val e = email.text.toString()
        if(e.isEmpty()) {
            email.error = "Required"
            return false
        }
        else {

            var regexforemail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
            if (!regexforemail.matcher(e).matches()) {
                email.error = "Correct email"
                return false
            }
            else {
                return true
            }

        }
    }

    private fun validateAddress(): Boolean {
        val a = address.text.toString()
        if (a.isEmpty()) {
            address.error = "Required"
            return false

        } else {
            var regexforaddress = Pattern.compile("[a-zA-Z0-9\\s]+(\\.)? [a-zA-Z]+")

            if (!regexforaddress.matcher(a).matches()) {
                address.error = "Correct address"
                return false
            }
            else {
                return true
            }
        }



    }


    private fun validatePhone(): Boolean {
        val p = phone.text.toString()
        if (p.isEmpty()) {
            phone.error = "Required"
            return false
        } else {

            var regexforphone =
                Pattern.compile("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{5,10}\$")
            if (!regexforphone.matcher(p).matches()) {
                phone.error = "Correct phone"
                return false
            }
            else {
                return true
            }
        }

    }

    private fun validatePass(): Boolean {
        val pas = pass.text.toString()

        if (pas.isEmpty()) {
            pass.error = "Required"
            return false
        }
        else {
            var regexforpassword = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}\$")
            if (!regexforpassword.matcher(pas).matches()) {
                pass.error = "Minimum eight characters, at least one letter,number,special character:"
                return false
            }
            else
            {
                return true
            }

        }

    }

    private fun validatecheckbox() : Boolean{
        if(!checkbox.isChecked){
            Toast.makeText(this, "If you have strongly agree with your registration then plz fill this check", Toast.LENGTH_SHORT).show()

            return false

        }
        else{
            return true
        }
    }







}















