package com.brins.translation.utils

import android.animation.ObjectAnimator
import android.content.Context
import android.view.View

object Animation {

    fun transfer(context : Context,view :View,property : String, values : Float ):ObjectAnimator{

        var animator = ObjectAnimator.ofFloat(view,property,values)
        return animator
    }
}