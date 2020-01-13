package com.saumya.retroliveroom.Activity

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.saumya.retroliveroom.ExtendApplicationClass
import com.saumya.retroliveroom.Model.DeveloperModel
import com.saumya.retroliveroom.Retrofit.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityRepository {

    val Base_URl = "https://github-trending-api.now.sh/"
    val TAG = MainActivityRepository::class.java.simpleName

    fun getDevelopers(): LiveData<List<DeveloperModel>>? {

        return ExtendApplicationClass.database?.developerDao()?.getAllDevelopers()
    }

    fun CallApiAndStoreInDB() {

        val gson = Gson()
        val retrofitClient = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Base_URl)
            .build()

        val restApi = retrofitClient.create<RestApi>(RestApi::class.java)

        restApi.getAllDevelopers().enqueue(object : Callback<List<DeveloperModel>> {
            override fun onFailure(call: Call<List<DeveloperModel>>, t: Throwable) {
                Log.e(TAG, "OOPs ! Something went wrong")
            }

            override fun onResponse(
                call: Call<List<DeveloperModel>>,
                response: Response<List<DeveloperModel>>
            ) {

                Log.e(TAG, response.body().toString())
                when (response.code()) {

                    200 -> {
                        Thread(Runnable {

                            ExtendApplicationClass.database?.developerDao()?.deleteDevelopers()

                            ExtendApplicationClass.database?.developerDao()
                                ?.insertDevelopers(response.body()!!)
                        }).start()
                    }
                }
            }
        })

    }

}