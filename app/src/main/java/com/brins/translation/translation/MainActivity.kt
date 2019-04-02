package com.brins.translation.translation
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.brins.translation.translation.fragment.mainfragment
import android.widget.Toast
import android.os.Process;



class MainActivity : AppCompatActivity() {

    var mExitTime : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        }

    private fun init() {
        val fragment_main = mainfragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.root_layout,fragment_main)
                .addToBackStack("fragment_main")
                .commit()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode != KeyEvent.KEYCODE_BACK || event.getAction() !== KeyEvent.ACTION_DOWN) {
            return super.onKeyDown(keyCode, event)
        }
        if (System.currentTimeMillis() - mExitTime > 2000) {
            Toast.makeText(applicationContext, "再按一次退出程序", Toast.LENGTH_SHORT).show()
            mExitTime = System.currentTimeMillis()
            return true
        }

        killApp()
        return true
    }

    private fun killApp() {
        Process.killProcess(Process.myPid())
    }


}
