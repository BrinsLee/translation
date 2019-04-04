package com.brins.translation.translation.api

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.View
import com.brins.translation.translation.AppConfig.*
import com.brins.translation.translation.model.Daily
import com.brins.translation.translation.model.Translation
import com.brins.translation.translation.model.dataSet
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.IDN
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

object PostRequest {

    fun getRetrofitFactory (baseurl: String) : PostRequest_Interface {

        val retrofit = Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build()
        return retrofit.create(PostRequest_Interface::class.java)
    }

    fun getbitmapRetrofitFactory (baseurl: String) : PostRequest_Interface {

        val retrofit = Retrofit.Builder().baseUrl(baseurl)
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
    fun StartTranslate(observer: Observer<String>, content: dataSet){

        if (content.targetlan.equals("ch")||content.sourcelan.equals("ch")){
            getRetrofitFactory(CHAOSHAN).getChaoshan(content.text!!)
                    .subscribeOn(Schedulers.io())
                    .map (object : Function<ResponseBody,String>{
                        override fun apply(it: ResponseBody): String {
                            var raw =it.string()
                            val result = getDoc(raw)
                            Log.d("postRequest",result)
                            return result
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer)

        }else {
            getRetrofitFactory(BASEURL).getCall(sourcelan = content.sourcelan!!
                    , targetlan = content.targetlan!!, content = content.text!!)
                    .subscribeOn(Schedulers.io())
                    .map(object : Function<ResponseBody, String> {
                        override fun apply(it: ResponseBody): String {
                            var result = it.string()
                            Log.d("postRequest", result)
                            return result
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer)
        }
    }

    fun GetDaily(observer: Observer<Daily>){
        getRetrofitFactory(DAILY).getDaily().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }


    fun GetBitmap(observer: Observer<Bitmap> ,path : String){
        getbitmapRetrofitFactory(IMAGE).getBitmap(path)
                .subscribeOn(Schedulers.io())
                .map(object : Function<ResponseBody,Bitmap>{
                    override fun apply(it: ResponseBody): Bitmap {
                        val result = it.byteStream()
                        val bitmap = BitmapFactory.decodeStream(result)
                        return bitmap
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }


    private fun getDoc(t: String):String {

        val doc = Jsoup.parse(t)
        val element = doc.select("table[class=table table-bordered table-striped]>tbody>tr")
        val text_elememts = element.select("td[class = hidden-480] a")
        val sb = StringBuilder()
        for (elm in text_elememts){
            sb.append("${elm.text()}\n")
        }
        if (sb.length!=0){
            return sb.toString()
        }else{
            return ""
        }

    }


}