package com.example.webservice_json.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.webservice_json.data.User
import com.example.webservice_json.databinding.UserListItemBinding

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    private var users: List<User> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = UserListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
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

    inner class UserViewHolder(private val binding: UserListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            binding.tvUserId.text = "User ID: ${user.userId}"
            binding.tvId.text = "ID: ${user.id}"
            binding.tvTitle.text = "Title: ${user.title}"
            binding.tvBody.text = "Body: ${user.body}"
        }
    }
}
