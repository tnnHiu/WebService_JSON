package com.example.webservice_json.data

import okhttp3.ResponseBody
import retrofit2.http.GET

interface UserApi {

    @GET("posts")
    suspend fun getUser(): ResponseBody

}