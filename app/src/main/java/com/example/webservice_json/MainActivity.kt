package com.example.webservice_json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webservice_json.adapter.UserListAdapter
import com.example.webservice_json.data.User
import com.example.webservice_json.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val gson = Gson()
    private lateinit var adapter: UserListAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = UserListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadData()
    }

    private fun loadData() {
        val userApi = RetrofitClient.create()
        CoroutineScope(Dispatchers.IO).launch {
            val response = userApi.getUser()
            val users = gson.fromJson<List<User>>(
                response.string(), object : TypeToken<List<User>>() {}.type
            )
            withContext(Dispatchers.Main) {
                adapter.setUser(users)
            }
        }
    }
}
