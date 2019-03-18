package com.brins.translation.translation

import android.animation.ObjectAnimator
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.brins.translation.translation.utils.Animation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animator = Animation.transfer(this,root_layout,"translationY",100f)
        tv_origin.setOnClickListener {
            root_layout.visibility = View.GONE
            animator.duration = 800
            animator.start()
        }


    }
}
