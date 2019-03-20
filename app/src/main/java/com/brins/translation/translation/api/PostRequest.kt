package com.brins.translation.translation.api

import com.brins.translation.translation.AppConfig.BASEURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostRequest {

    fun getRetrofitFactory () : PostRequest_Interface {

        val retrofit = Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(PostRequest_Interface::class.java)
    }
}