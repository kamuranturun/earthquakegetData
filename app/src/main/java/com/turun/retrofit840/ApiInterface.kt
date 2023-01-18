package com.turun.retrofit840

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("kandilli/index.php?all")
    fun getData(): Call<List<MyDataItem>>
}