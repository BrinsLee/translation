package com.brins.translation.translation

import android.app.Application
import com.youdao.sdk.app.YouDaoApplication

class TranslateApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (YouDaoApplication.getApplicationContext() == null)
            YouDaoApplication.init(this, "77099dae9a0e7347")
        //        YouDaoApplication.init(this,"1b8cb73b7a069078");//创建应用，每个应用都会有一个Appid，绑定对应的翻译服务实例，即可使用
        //        YouDaoApplication.init(this,"72103667078f5b93");//创建应用，每个应用都会有一个Appid，绑定对应的翻译服务实例，即可使用
        instance = this
    }

    companion object {

        var instance: TranslateApplication? = null

    }

}