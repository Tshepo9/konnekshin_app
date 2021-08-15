package com.example.ekse.login

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ekse.ListUsers.List_Layout_People
import com.example.splashscreen.R
import com.parse.ParseUser


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

         //set up event listener for signup button
        val SignUp = findViewById<Button>(R.id.signupBtn)
        SignUp.setOnClickListener{

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }

        //get the values of views in the login
        var userlogin =findViewById<EditText>(R.id.userlogin)
        var Pass =findViewById<EditText>(R.id.pass)

        val Login = findViewById<Button>(R.id.loginbtn)

       Login.setOnClickListener {

           ParseUser.logInInBackground(
               userlogin.getText().toString(),
               Pass.getText().toString()
           ) { user, e ->
               if (user != null) {
                   // Hooray! The user is logged in
                   val intent = Intent(this, List_Layout_People::class.java)
                   startActivity(intent)
               } else {
                   showAlert("Invalid!", "Username or Password"+"!")
                   // Signup failed. Look at the ParseException to see what happened.
                   ParseUser.logOut()


               }
           }
       }


    }

    private fun showAlert(title: String, message: String) {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
                // don't forget to change the line below with the names of your Activities

            })
        val ok: android.app.AlertDialog = builder.create()
        ok.show()
    }

}
