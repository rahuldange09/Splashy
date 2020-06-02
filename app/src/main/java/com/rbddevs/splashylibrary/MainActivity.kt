package com.rbddevs.splashylibrary

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.rbddevs.splashy.Splashy


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSplashy()
    }

    private fun setSplashy() {
        Splashy(this)
            .setLogo(R.drawable.splashy)
            .setAnimation(Splashy.Animation.GROW_LOGO_FROM_CENTER)
            .setBackgroundResource(R.color.black)
            .setTitleColor(R.color.white)
            .setProgressColor(R.color.white)
            .setTitle(R.string.splashy)
            .setSubTitle(R.string.splash_screen_made_easy)
            .setFullScreen(true)
            .setSubTitleFontStyle("fonts/satisfy_regular.ttf")
            .setClickToHide(true)
            .setDuration(5000)
            .show()

        Splashy.onComplete(object : Splashy.OnComplete {
            override fun onComplete() {
                Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_SHORT).show()
            }

        })
    }

    public fun showSplash(v: View) {
        setSplashy()
        // Hides after 1sec
        Handler().postDelayed({
            Splashy.hide()
        }, 1000)
    }

}
