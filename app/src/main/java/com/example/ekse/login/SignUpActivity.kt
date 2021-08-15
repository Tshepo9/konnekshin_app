package com.example.ekse.login

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ekse.ListUsers.List_Layout_People
import com.example.splashscreen.R
import com.parse.ParseException
import com.parse.ParseUser


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //register a user
        var username =findViewById<EditText>(R.id.username)
        var Password =findViewById<EditText>(R.id.password)
        var Email =findViewById<EditText>(R.id.emailReg)

        val signup = findViewById<Button>(R.id.signup)
        signup.setOnClickListener{
            val user = ParseUser();
            // Set the user's username and password, which can be obtained by a forms
            user.username = username.text.toString();
            user.setPassword(Password.text.toString());
            user.email = Email.text.toString();

            user.signUpInBackground { e: ParseException? ->
                if (e == null) {
                    showAlert("Successful Sign Up!", "Welcome" + username
                            +"!");
                } else {

                    ParseUser.logOut();
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
    private fun showAlert(title: String, message: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@SignUpActivity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
                // don't forget to change the line below with the names of your Activities
                val intent = Intent(this, List_Layout_People::class.java)
                startActivity(intent)
            })
        val ok: AlertDialog = builder.create()
        ok.show()
    }
}