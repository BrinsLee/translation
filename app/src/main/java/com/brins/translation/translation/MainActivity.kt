package com.brins.translation.translation

import android.animation.ObjectAnimator
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.brins.translation.translation.fragment.mainfragment
import com.brins.translation.translation.utils.Animation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
       /* val animator = Animation.transfer(this,input_card,"translationY",-150f)
        val animator2 = Animation.transfer(this,input_card,"translationY",0f)
        tv_origin.setOnFocusChangeListener { v, hasFocus ->
            run {

                if (hasFocus) {
                    toolBarLayout.visibility = View.GONE
                    animator.duration = 800
                    animator.start()
                } else {
                    toolBarLayout.visibility = View.VISIBLE
                    animator2.duration = 800
                    animator2.start()
                }
            }*/
        }

    private fun init() {
        val fragment_main = mainfragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.root_layout,fragment_main)
                .addToBackStack("fragment_main")
                .commit()
    }

}
