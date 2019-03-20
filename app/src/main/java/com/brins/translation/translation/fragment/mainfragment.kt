package com.brins.translation.translation.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.Html
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.brins.translation.translation.R
import com.brins.translation.translation.api.PostRequest
import com.brins.translation.translation.api.PostRequest_Interface
import com.brins.translation.translation.model.Translation
import com.brins.translation.translation.utils.Animation
import com.brins.translation.translation.utils.ToastUtils
import com.youdao.sdk.chdict.ChDictTranslate
import com.youdao.sdk.chdict.ChDictor
import com.youdao.sdk.chdict.DictListener
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class mainfragment : Fragment(){

    var request : PostRequest_Interface? = null
    var call : Call<Translation>? = null
    private var chDictor: ChDictor? = null
    internal lateinit var chTslate: List<ChDictTranslate>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        request = PostRequest.getRetrofitFactory()
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_chinese.setOnClickListener {
            lookup_chinese()
        }
        val animator = Animation.transfer(context!!, input_card, "translationY", -150f)
        val animator2 = Animation.transfer(context!!, input_card, "translationY", 0f)
        tv_origin.setOnFocusChangeListener { v, hasFocus ->
            run {

                if (hasFocus) {
                    animator.duration = 800
                    animator.start()
                    real_time_layout.visibility = View.VISIBLE
                } else {
                    animator2.duration = 800
                    animator2.start()
                    real_time_layout.visibility = View.GONE
                }
            }
        }
    }

    private fun lookup_chinese() {
        //TODO 初始化
        val text = tv_origin.text.toString()
        if (TextUtils.isEmpty(text)) {
            ToastUtils.show("请输入要查询的词")
            return
        }

        if (chDictor == null) {
            /*
             * 请确保设置的路径下包含汉语词典的离线包
             */
            //            //设置离线句子库位置，确保Environment.getExternalStorageDirectory()+/update路径
//            chDictor = ChDictor(Environment.getExternalStorageDirectory().toString() + "/update", false)

            chDictor = ChDictor("dict", true)
        }
        try {
            chDictor!!.init()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        chDictor!!.lookup(text, object : DictListener {

            override fun onResult(chTs: List<ChDictTranslate>) {
                chTslate = chTs
                showResult(chTs)
            }

            override fun onError(q: String, info: String) {

            }
        })    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                mainfragment().apply {

                }
    }


    fun showResult(chTs: List<ChDictTranslate>) {

        var text = "查询失败"
        val sb = StringBuilder()
        for (chT in chTs) {
            if (chT.success()) {
                sb.append("<p>单词：" + chT.query + "<br/>")
                sb.append("<p>发音：" + chT.phone + "<br/>")
                val list = chT.translations
                if (list != null) {
                    sb.append("<p>含义如下：")
                    for (chdictMeans in list) {
                        val trs = chdictMeans.translate
                        sb.append("<br/><br/>解释：" + trs
                                + "<br/>例句：")
                        val lineList = chdictMeans
                                .examLines ?: continue
                        for (line in lineList) {
                            val texts = line.text
                            var span: String? = null
                            if (line.isHighlight) {
                                span = ("<span><font color=\"#ff0000\">"
                                        + texts
                                        + "</font></span>")
                            } else {
                                span = ("<span><font color=\"#808080\">"
                                        + texts
                                        + "</font></span>")
                            }
                            sb.append(span)
                        }
                    }
                }
                sb.append("</p>")
            }
        }
        text = sb.toString()
        activity!!.runOnUiThread {
            tv_target.text = text
            more.visibility = View.VISIBLE
        }


    }
}
