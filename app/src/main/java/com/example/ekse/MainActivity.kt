package com.example.ekse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ekse.ListUsers.PeopleAdapter
import com.example.ekse.ListUsers.User
import com.example.splashscreen.R
import com.example.ekse.ListUsers.List_Layout_People

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myrecycler )

        val users = ArrayList<User>()

        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))

        //create an assign adapter
        val adapter = PeopleAdapter(users)
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.button_test).setOnClickListener{
            val intent = Intent(this,List_Layout_People::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}