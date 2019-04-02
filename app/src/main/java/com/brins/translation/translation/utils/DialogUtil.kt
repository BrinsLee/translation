package com.brins.translation.translation.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brins.translation.translation.R
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.bottom_dialog.*


class DialogUtil private constructor(var context :Context){

    companion object {
       fun Instance(context: Context):DialogUtil{
           return DialogUtil(context)
       }
    }

    fun createDialog(view : View):Dialog{
        val dialog = Dialog(context, R.style.BottomDialog)
        dialog.setContentView(view)
        val params = view.layoutParams as ViewGroup.MarginLayoutParams
        params.width = context.resources.displayMetrics.widthPixels - dp2px(16f)
        params.bottomMargin = dp2px(8f)
        view.layoutParams = params
        dialog.window.setGravity(Gravity.BOTTOM)
        dialog.window.setWindowAnimations(R.style.BottomDialog_Animation)
        return dialog
    }

    fun dp2px(dpVal: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.resources.displayMetrics).toInt()
    }
}