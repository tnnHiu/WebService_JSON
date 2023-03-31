package com.example.webservice_json.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webservice_json.R
import com.example.webservice_json.data.User

class UserListAdapter :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    private var users: List<User> = listOf()


    @SuppressLint("NotifyDataSetChanged")
    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return UserViewHolder(view)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }
    override fun getItemCount(): Int = users.size
    @SuppressLint("NotifyDataSetChanged")
    fun setUser(users: List<User>?) {
        if (users != null) {
            this.users = users
            notifyDataSetChanged()
        }
    }

    inner class UserViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val tvUserId: TextView = itemView.findViewById(R.id.tvUserId)
        private val tvId: TextView = itemView.findViewById(R.id.tvId)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvBody: TextView = itemView.findViewById(R.id.tvBody)
        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            tvUserId.text = "User ID: ${user.userId.toString()}"
            tvId.text = "ID: ${user.id.toString()}"
            tvTitle.text = "Title: ${user.title.toString()}"
            tvBody.text = "Body: ${user.body.toString()}"
        }
    }
}
