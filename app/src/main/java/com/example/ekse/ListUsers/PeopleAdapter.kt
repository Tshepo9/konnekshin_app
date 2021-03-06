package com.example.ekse.ListUsers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscreen.R

class PeopleAdapter( val users: ArrayList<User>):RecyclerView.Adapter<PeopleAdapter.MyViewHolder>() {


    var onItemClick: ((User) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

      val view =  LayoutInflater.from(parent.context).inflate(R.layout.list_view_people,parent,false)
       return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user  = users[position]
        holder.setData(user)
    }

    override fun getItemCount(): Int {
        
        return users.size
    }

    inner class MyViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){

           fun setData(users :User){
            val Name = itemView.findViewById(R.id.Name_id) as TextView
            val SurName = itemView.findViewById(R.id.Surname_id) as TextView
            val discription = itemView.findViewById(R.id.description_id) as TextView
            val kilometer = itemView.findViewById(R.id.Km_Id) as TextView

            Name.text = users.name
            SurName.text = users.surname
            discription.text = users.description
             kilometer.text = users.kilometer
           }

        // execute
            init {
              itemView.setOnClickListener {

               onItemClick?.invoke(users[adapterPosition])
                  val view = itemView.findViewById<LinearLayout>(R.id.expand_id )

                  if (view.isVisible)
                  {
                      view.visibility = View.GONE

                  }
                  else
                  {
                      view.visibility = View.VISIBLE
                  }
               //onItemClick?.invoke(LinearLayout(this.adapterPosition))
             }

           }


      }
    }
