package com.saumya.retroliveroom.Retrofit

import com.saumya.retroliveroom.Model.DeveloperModel
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {

    @GET("developers")
    fun getAllDevelopers(): Call<List<DeveloperModel>>

}