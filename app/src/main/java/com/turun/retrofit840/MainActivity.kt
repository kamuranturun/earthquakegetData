package com.turun.retrofit840

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//const val BASE_URL= "https://api.berkealp.net/kandilli.html/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager:LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycvleView_users.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recycvleView_users.layoutManager=linearLayoutManager

        getMydata()

    }

    private fun getMydata() {
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.berkealp.net/")
            .build()
            .create(ApiInterface::class.java)




        val retrofitData= retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {

                val responseBody= response.body()!!

                myAdapter= MyAdapter(baseContext,responseBody)
                myAdapter.notifyDataSetChanged()
                recycvleView_users.adapter= myAdapter

            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                println("hata"+t.message)
            }
        })
    }
}