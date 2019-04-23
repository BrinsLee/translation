package com.brins.translation.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.lang.Exception

class BitmapUtil {

    companion object {
        fun saveBitmap(bitmap : Bitmap):String{
            val bao : ByteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,bao)
            val background = bao.toByteArray()
            return Base64.encodeToString(background,Base64.DEFAULT)
        }

        fun decodeBitmap (bitmap_string : String) :Bitmap?{
            try {
                val bitmapArray = Base64.decode(bitmap_string,Base64.DEFAULT)
                val bitmap = BitmapFactory.decodeByteArray(bitmapArray,0,bitmapArray.size)
                return bitmap
            }catch (e: Exception){
                return null
            }
        }
    }
}