package com.brins.translation.translation.api

import android.annotation.SuppressLint
import android.util.Log
import com.brins.translation.translation.AppConfig.BASEURL
import com.brins.translation.translation.AppConfig.languageSelect
import com.brins.translation.translation.model.Translation
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.reactivestreams.Subscription
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

object PostRequest {

    fun getRetrofitFactory () : PostRequest_Interface {

        val retrofit = Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build()
        return retrofit.create(PostRequest_Interface::class.java)
    }

    private fun  getClient() : OkHttpClient{
        val builder : OkHttpClient.Builder = OkHttpClient().newBuilder()
        val client = builder.connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build()
        return client
    }

    @SuppressLint("CheckResult")
    fun StartTranslate(observer: Consumer<String>, content: String){

        getRetrofitFactory().getCall(sourcelan = languageSelect["English"]!!
                ,targetlan = languageSelect["Chinese Simplified"]!!, content = URLEncoder.encode(content,"UTF-8"))
                .subscribeOn(Schedulers.io())
                .map (object : Function<ResponseBody,String>{
                    override fun apply(it: ResponseBody): String {
                        Log.d("postRequest",it.string())
                        return it.string()
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }


}