package com.brins.translation.translation.api

import com.brins.translation.translation.model.Translation
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded



interface PostRequest_Interface {

    @POST("translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
    @FormUrlEncoded
    fun getCall(@Field("i") targetSentence: String): Call<Translation>

}