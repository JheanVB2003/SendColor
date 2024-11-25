package com.example.sendcolor.service

import com.example.sendcolor.repository.ColorResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ServiceColor {

        @POST("api/mock/search-color")
        @Headers("Content-Type: text/plain")
        fun getColorInfo(@Body hex: String): Call<ColorResponse>


}