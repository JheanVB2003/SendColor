package com.example.sendcolor.service

import com.example.sendcolor.repository.ColorResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ServiceColor {

        @POST("api/search-color")
        @Headers("Content-Type: text/plain")
        fun getColorInfo(@Body body: RequestBody): Call<ColorResponse>




}