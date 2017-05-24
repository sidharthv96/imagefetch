package com.sidharth.imagefetch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.picasso.Picasso
import java.io.Console
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.converter.gson.GsonConverterFactory
import android.R.attr.data
import android.util.Log
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.R.attr.data






class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mRecyclerView = findViewById(R.id.list) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        val mCardAdapter = CardAdapter(this)
        mRecyclerView.adapter = mCardAdapter
//        val
//        val iv: ImageView?  = this.findViewById(R.id.imgview) as ImageView?
//        Picasso.with(this).load("http://www.androidbegin.com/tutorial/flag/india.png").into(iv)


        val retrofit = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl("http://www.androidbegin.com/").build()
        val world = retrofit.create(WorldAPI::class.java)
        var data = world.getPopulation()
        data.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { d ->
                    for (c in d.worldpopulation!!){
//                        Log.e("AD",c.flag)
                        mCardAdapter.addData(c)
                    }
                }
    }
}
