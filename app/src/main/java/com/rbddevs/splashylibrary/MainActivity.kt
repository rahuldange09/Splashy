package com.rbddevs.splashylibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.rbddevs.splashy.Splashy

class MainActivity : AppCompatActivity() {
    lateinit var sp: Splashy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSplashy()


    }

    private fun setSplashy() {
        Splashy(this)
            .setLogo(R.drawable.splashy)
            .setAnimation(Splashy.Animation.GLOW_LOGO)
            .setBackgroundResource(R.color.black)
            .setTitleColor(R.color.white)
            .setProgressColor(R.color.white)
            .setTitle(R.string.splashy)
            .setSubTitle(R.string.splash_screen_made_easy)
            .setFullScreen(true)
            .show()

        Splashy.onComplete(object : Splashy.OnComplete {
            override fun onComplete() {
                Toast.makeText(this@MainActivity, "Logged In", Toast.LENGTH_SHORT).show()
            }

        })
    }

    public fun showSplash(v: View) {
        setSplashy()
    }

}
