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
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.brins.translation.translation.R
import com.brins.translation.translation.api.PostRequest
import com.brins.translation.translation.api.PostRequest.StartTranslate
import com.brins.translation.translation.api.PostRequest_Interface
import com.brins.translation.translation.model.Translation
import com.brins.translation.translation.utils.Animation
import com.brins.translation.translation.utils.ToastUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_main.*
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class mainfragment : Fragment(){

    var request : PostRequest_Interface? = null
    var call : Call<Translation>? = null

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
        StartTranslate( object : Consumer<String>{
            override fun accept(t: String?) {
                if(TextUtils.isEmpty(t)){
                    Toast.makeText(this@mainfragment.activity,"result is null",Toast.LENGTH_SHORT).show()
                }else{

                    Log.d("mainfragemnt",t)
                    var result : String? = t
                    /*val jsonArray = JSONArray(t.string()).getJSONArray(0)
                    for (i in 0 .. jsonArray.length()) {
                        result += jsonArray.getJSONArray(i).getString(0)
                    }*/
                    tv_target.text = t
                }            }


        },"apple")

    }

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

}
