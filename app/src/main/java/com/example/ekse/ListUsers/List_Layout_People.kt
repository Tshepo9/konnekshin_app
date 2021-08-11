package com.example.ekse.ListUsers

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ekse.MainActivity
import com.example.ekse.messaging.chat
import com.example.splashscreen.R
import com.google.android.material.navigation.NavigationView


class List_Layout_People : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_layout_people)

        //recycler view and adapter int code
        val recyclerView = findViewById<RecyclerView>(R.id.myrecycler )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.apply {
           hasFixedSize()
            addItemDecoration(DividerItemDecoration(this.context,DividerItemDecoration.VERTICAL))
        }

        //navi event
        onSupportNavigateUp()

        val users = ArrayList<User>()

        users.add(User(name = "riili",surname = "gontse",description="plumbery",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tsgedis0",surname = "boshiama",description="eletricity",kilometer = "9km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))
        users.add(User(name = "Tshepo",surname = "Monene",description="plumber",kilometer = "5km"))


        //create an assign adapter
        val adapter = PeopleAdapter(users)
        recyclerView.adapter = adapter

        // add on click for elements//recycler view event
        adapter.onItemClick = {

          //val view = findViewById<LinearLayout>(R.id.expand_id )


        }

        //menu bar event listenr



        //menu bar clicked






    }
    //
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.botton_nav_bar, menu)
        return true
    }
     //code for selecting menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menubar -> {
                // Action goes here

                var view = findViewById<NavigationView>(R.id.nav_view)
                if (view.isVisible)
                {
                    view.visibility = View.GONE

                }
                else
                {
                    view.visibility = View.VISIBLE
                }
                true
            }
            R.id.message -> {
                // Action goes here
                val intent = Intent(this, chat::class.java)
                        startActivity(intent)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }
}