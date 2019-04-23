package com.brins.translation.api

import com.brins.translation.AppConfig.USER_AGENT
import com.brins.translation.model.Daily
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*


interface PostRequest_Interface {

    @Headers ("Accept: */*",
            "User-Agent: $USER_AGENT")//https://translate.google.cn/translate_a/single?client=gtx&sl=zh-CN&tl=en&dt=t&q=你们好
    @GET("translate_a/single")//https://translate.google.cn/translate_a/single?client=gtx&sl=en&tl=zh-cn&dt=t&q=apple
    fun getCall(@Query("client") client: String ="gtx",@Query("sl")sourcelan : String
                ,@Query("tl")targetlan: String, @Query("dt")t :String="t", @Query("q")content: String): Observable <ResponseBody>

    @GET("dsapi")
    fun getDaily(): Observable<Daily>


    @GET("news/word/{name}")
    fun getBitmap(@Path("name") name :String):Observable<ResponseBody>

    @GET("baike")//https://www.mogher.com/baike?kw=你好
    fun getChaoshan(@Query("kw") kw :String):Observable<ResponseBody>
}