package com.brins.translation.translation.fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast

import com.brins.translation.translation.R
import com.brins.translation.translation.api.PostRequest
import com.brins.translation.translation.api.PostRequest.StartTranslate
import com.brins.translation.translation.api.PostRequest_Interface
import com.brins.translation.translation.utils.DialogUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.bottom_dialog.*
import kotlinx.android.synthetic.main.fragment_main.*
import org.json.JSONArray


class mainfragment : Fragment(){

    var request : PostRequest_Interface? = null
    lateinit var dialog : Dialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        request = PostRequest.getRetrofitFactory()

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       /* val animator = Animation.transfer(context!!, input_card, "translationY", -150f)
        val animator2 = Animation.transfer(context!!, input_card, "translationY", 0f)*/
        setListener()
    }

    private fun setListener() {
        tv_origin.setOnFocusChangeListener { v, hasFocus ->
            run {

                if (hasFocus) {
                    /*animator.duration = 800
                    animator.start()*/
                    target_layout.visibility = View.VISIBLE
                } else {
                    /*animator2.duration = 800
                    animator2.start()*/
                    target_layout.visibility = View.GONE
                }
            }
        }
        tv_origin.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (tv_origin.text.toString().length == 0 || TextUtils.isEmpty(tv_origin.text.toString())){
                    return
                }else{
                    Translate(tv_origin.text.toString())
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
        origin_lan.setOnClickListener {

            dialog.show()
        }
        target_lan.setOnClickListener {
            dialog.show()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val language = arrayOf(getString(R.string.Afrikaans),getString(R.string.Albanian)
                ,getString(R.string.Arabic),getString(R.string.Armenian),getString(R.string.Azerbaijani),getString(R.string.Basque),getString(R.string.Belarusian),getString(R.string.Bengali)
                ,getString(R.string.Bosnian),getString(R.string.Bulgarian),getString(R.string.Catalan),getString(R.string.Cebuano),getString(R.string.Chichewa),getString(R.string.ChineseSimplified)
                ,getString(R.string.ChineseTraditional),getString(R.string.Corsican),getString(R.string.Croatian),getString(R.string.Czech),getString(R.string.Danish),getString(R.string.Dutch)
                ,getString(R.string.English),getString(R.string.Esperanto),getString(R.string.Estonian),getString(R.string.Filipino),getString(R.string.Finnish),getString(R.string.French)
                ,getString(R.string.Frisian),getString(R.string.Galician),getString(R.string.Georgian),getString(R.string.German),getString(R.string.Geek),getString(R.string.Gujarati)
                ,getString(R.string.HaitianCreole),getString(R.string.Hausa),getString(R.string.Hawaiian),getString(R.string.Hebrew),getString(R.string.Hindi),getString(R.string.Hmong)
                ,getString(R.string.Hungarian),getString(R.string.Icelandic),getString(R.string.Igbo),getString(R.string.Indonesian),getString(R.string.Irish),getString(R.string.Italian)
                ,getString(R.string.Japanese),getString(R.string.Javanese),getString(R.string.Kannada),getString(R.string.Kazakh),getString(R.string.Khmer),getString(R.string.Korean)
                ,getString(R.string.Kurdish),getString(R.string.Kyrgyz),getString(R.string.Lao),getString(R.string.Latin),getString(R.string.Latvian),getString(R.string.Lithuanian)
                ,getString(R.string.Luxembourgish),getString(R.string.Macedonian),getString(R.string.Malagasy),getString(R.string.Malay),getString(R.string.Malayalam),getString(R.string.Maltese)
                ,getString(R.string.Maori),getString(R.string.Marathi),getString(R.string.Mongolian),getString(R.string.Myanmar),getString(R.string.Nepali),getString(R.string.Norwegian)
                ,getString(R.string.Pashto),getString(R.string.Persian),getString(R.string.Polish),getString(R.string.Portuguese),getString(R.string.Punjabi),getString(R.string.Romanian)
                ,getString(R.string.Russian),getString(R.string.Samoan),getString(R.string.ScotsGaelic),getString(R.string.Serbian),getString(R.string.Sesotho),getString(R.string.Shona)
                ,getString(R.string.Sindhi),getString(R.string.Sinhala),getString(R.string.Slovak),getString(R.string.Slovenian),getString(R.string.Somali),getString(R.string.Spanish)
                ,getString(R.string.Sudanese),getString(R.string.Swahili),getString(R.string.Swedish),getString(R.string.Tajik),getString(R.string.Tamil),getString(R.string.Telugu)
                ,getString(R.string.Thai),getString(R.string.Turkish),getString(R.string.Ukrainian),getString(R.string.Urdu),getString(R.string.Uzbek),getString(R.string.Vietnamese)
                ,getString(R.string.Welsh),getString(R.string.Xhosa),getString(R.string.Yiddish),getString(R.string.Yoruba),getString(R.string.Zulu)
        )
        val adapter = ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,language)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_dialog,null)
        val list = view.findViewById(R.id.dialog_list) as ListView
        list.adapter = adapter
        dialog = DialogUtil.Instance(context).createDialog(view)
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun Translate(text : String){
        StartTranslate( object : Observer<String>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onComplete() {

            }

            override fun onNext(t: String) {
                if(TextUtils.isEmpty(t)){
                    Toast.makeText(this@mainfragment.activity,"result is null",Toast.LENGTH_SHORT).show()
                }else{

                    Log.d("mainfragemnt",t)
                    var result = ""
                    val jsonArray = JSONArray(t).getJSONArray(0)
                    for (i in 0 until  jsonArray.length()) {
                        result += jsonArray.getJSONArray(i).getString(0)
                    }
                    tv_target.text = result

                }
            }

            override fun onError(t: Throwable) {
            }


        },text)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                mainfragment().apply {

                }
    }

}
