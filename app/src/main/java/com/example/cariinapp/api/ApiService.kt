package com.example.cariinapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

class ApiService {
    private val apiService: ApiServiceInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://cariinapi-cxpgdj753q-et.a.run.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiServiceInterface::class.java)
    }

    fun fetchData() {
        val call = apiService.getSomeData()
        call.enqueue(object : Callback<users> {
            override fun onResponse(call: Call<users>, response: Response<users>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    // Handle the response here
                    println(data)
                } else {
                    // Handle error response
                }
            }

            override fun onFailure(call: Call<users>, t: Throwable) {
                // Handle request failure
                t.printStackTrace()
            }
        })
    }

    // Define other API endpoints as needed
    interface ApiServiceInterface {
        @GET("your/endpoint")
        fun getSomeData(
            @Query("email") email: String,
            @Query("password") password: String
        ): Call<users>

        abstract fun getSomeData(): Call<users>
    }
}