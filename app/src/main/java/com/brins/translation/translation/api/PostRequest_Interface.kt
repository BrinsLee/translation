package com.brins.translation.translation.api

import com.brins.translation.translation.AppConfig.USER_AGENT
import com.brins.translation.translation.model.Translation
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.io.InputStream


interface PostRequest_Interface {

    @Headers ("Accept: */*",
            "User-Agent: $USER_AGENT")//https://translate.google.cn/translate_a/single?client=gtx&sl=zh-CN&tl=en&dt=t&q=你们好
    @GET("translate_a/single")//https://translate.google.cn/translate_a/single?client=gtx&sl=en&tl=zh-cn&dt=t&q=apple
    fun getCall(@Query("client") client: String ="gtx",@Query("sl")sourcelan : String
                ,@Query("tl")targetlan: String, @Query("dt")t :String="t", @Query("q")content: String): Observable <ResponseBody>

}