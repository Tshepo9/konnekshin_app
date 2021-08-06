package com.example.ekse.ListUsers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscreen.R

class List_Layout_People : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_layout_people)

        val recyclerView = findViewById<RecyclerView>(R.id.myrecycler )
        recyclerView.layoutManager = LinearLayoutManager(this)

        val users = ArrayList<User>()

        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))

        //create an assign adapter
        val adapter = PeopleAdapter(users)
        recyclerView.adapter = adapter
    }
}