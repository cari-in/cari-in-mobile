package com.example.cariinapp.api
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class ApiManager {
    fun fetchDataFromApi(): String? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://cariinapi-cxpgdj753q-et.a.run.app/users")
            .build()
        val response: Response = client.newCall(request).execute()
        return response.body?.string()
    }
}