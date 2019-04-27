package com.rbddevs.splashy

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_splashy.*


class SplashyActivity : AppCompatActivity() {

    var time: Long = 2000
    var isIntermediate = false

    companion object {

        // Splash Screen Time
        internal const val TIME = "time"
        internal const val INFINITE_TIME = "intermediate_time"


        // Title Attributes
        internal const val SHOW_TITLE = "show_title"
        internal const val TITLE = "title"
        internal const val TITLE_RESOURCE = "title_resource"
        internal const val TITLE_SIZE = "title_size"
        internal const val TITLE_COLOR = "title_color"
        internal const val TITLE_COLOR_VALUE = "title_color_value"

        // Subtitle attributes
        //  internal const val SHOW_SUBTITLE = "show_subtitle"
        internal const val SUBTITLE = "subtitle"
        internal const val SUBTITLE_RESOURCE = "subtitle_resource"
        internal const val SUBTITLE_SIZE = "subtitle_size"
        internal const val SUBTITLE_COLOR = "subtitle_color"
        internal const val SUBTITLE_COLOR_VALUE = "subtitle_color_value"
        internal const val SUBTITLE_ITALIC = "subtitle_italic"

        // Splash Logo
        internal const val SHOW_LOGO = "show_logo"
        internal const val LOGO = "logo"
        internal const val LOGO_WIDTH = "logo_width"
        internal const val LOGO_HEIGHT = "logo_height"
        internal const val LOGO_SCALE_TYPE = "logo_scale_type"

        // Animation
        internal const val ANIMATION_TYPE = "animation_type"
        internal const val ANIMATION_DURATION = "animation_duration"


        // Progress bar
        internal const val SHOW_PROGRESS = "show_progress"
        internal const val PROGRESS_COLOR = "progress_color"
        internal const val PROGRESS_COLOR_VALUE = "progress_color_value"

        // Splash Screen Background
        internal const val BACKGROUND_COLOR = "background_color"
        internal const val BACKGROUND_COLOR_VALUE = "background_color_value"
        internal const val BACKGROUND_RESOURCE = "background_image"

        // Status and Navigation Bar Color
//        const val STATUS_NAV_BAR_COLOR_AS_BACKGROUND_COLOR = "status_nav_bar_color_as_background_color"
        const val FULL_SCREEN = "full_screen"

        // on OnComplete listener
        internal var onComplete: Splashy.OnComplete? = null


    }

    var progressVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashyTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashy)


        setLogo()

        setTitle()

        setSubTitle()

        setProgress()

        setSplashBackground()

        setFullScreen()

        setAnimation()

        setTime()

        if (!isIntermediate)
            showSplashy()


    }


    private fun setLogo() {
        if (intent.hasExtra(SHOW_LOGO)) {
            if (!intent.getBooleanExtra(SHOW_LOGO, true)) ivLogo.visibility = View.GONE
        }

        if (intent.hasExtra(LOGO)) {
            ivLogo.setImageResource(intent.getIntExtra(LOGO, R.drawable.splashy))
        }

        if (intent.hasExtra(LOGO_WIDTH) || intent.hasExtra(LOGO_HEIGHT)) {
            val width = intent.getIntExtra(LOGO_WIDTH, 200)
            val height = intent.getIntExtra(LOGO_HEIGHT, 200)
            val widthInDp =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width.toFloat(), resources.displayMetrics)
                    .toInt()
            val heightInDp =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height.toFloat(), resources.displayMetrics)
                    .toInt()
            ivLogo.layoutParams.width = widthInDp
            ivLogo.layoutParams.height = heightInDp
            ivLogo.requestLayout()


        }

        if (intent.hasExtra(LOGO_SCALE_TYPE)) {
            val scaleType: ImageView.ScaleType = intent.getSerializableExtra(LOGO_SCALE_TYPE) as ImageView.ScaleType
            ivLogo.scaleType = scaleType
            ivLogo.requestLayout()
        }
    }

    private fun setTitle() {
        if (intent.hasExtra(SHOW_TITLE)) {
            if (!intent.getBooleanExtra(SHOW_TITLE, true)) tvTitle.visibility = View.GONE
        }
        if (intent.hasExtra(TITLE)) {
            tvTitle.text = intent.getStringExtra(TITLE)
        }
        if (intent.hasExtra(TITLE_RESOURCE)) {
            tvTitle.text = resources.getString(intent.getIntExtra(TITLE_RESOURCE, R.string.splashy))
        }
        if (intent.hasExtra(TITLE_SIZE)) {
            tvTitle.textSize = intent.getFloatExtra(TITLE_SIZE, 40F)
        }
        if (intent.hasExtra(TITLE_COLOR)) {
            tvTitle.setTextColor(ContextCompat.getColor(this, intent.getIntExtra(TITLE_COLOR, R.color.black)))
        }
        if (intent.hasExtra(TITLE_COLOR_VALUE)) {
            tvTitle.setTextColor(Color.parseColor(intent.getStringExtra(TITLE_COLOR_VALUE)))
        }
    }

    private fun setSubTitle() {

        if (intent.hasExtra(SUBTITLE)) {
            tvSubTitle.text = String.format("%s ", intent.getStringExtra(SUBTITLE))
            tvSubTitle.visibility = View.VISIBLE
        }
        if (intent.hasExtra(SUBTITLE_RESOURCE)) {
            tvSubTitle.text = resources.getString(intent.getIntExtra(SUBTITLE_RESOURCE, R.string.splashy_subtitle))
            tvSubTitle.visibility = View.VISIBLE
        }
        if (intent.hasExtra(SUBTITLE_SIZE)) {
            tvSubTitle.textSize = intent.getFloatExtra(SUBTITLE_SIZE, 18F)
        }
        if (intent.hasExtra(SUBTITLE_COLOR)) {
            tvSubTitle.setTextColor(ContextCompat.getColor(this, intent.getIntExtra(SUBTITLE_COLOR, R.color.eight)))
        }
        if (intent.hasExtra(SUBTITLE_COLOR_VALUE)) {
            tvSubTitle.setTextColor(Color.parseColor(intent.getStringExtra(SUBTITLE_COLOR_VALUE)))
        }
        if (intent.hasExtra(SUBTITLE_ITALIC)) {
            if (!intent.getBooleanExtra(SUBTITLE_ITALIC, true)) tvSubTitle.setTypeface(null, Typeface.NORMAL)
        }
    }

    private fun setProgress() {
        if (intent.hasExtra(SHOW_PROGRESS)) {
            progressVisible = intent.getBooleanExtra(SHOW_PROGRESS, false);
            if (progressVisible) pbLoad.visibility = View.VISIBLE
        }

        if (intent.hasExtra(PROGRESS_COLOR)) {
            val color = intent.getIntExtra(PROGRESS_COLOR, R.color.black)
            pbLoad.indeterminateDrawable.setColorFilter(ContextCompat.getColor(this, color), PorterDuff.Mode.SRC_IN)
        }
        if (intent.hasExtra(PROGRESS_COLOR_VALUE)) {
            val color = intent.getStringExtra(PROGRESS_COLOR_VALUE)
            pbLoad.indeterminateDrawable.setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN)
        }
    }

    private fun setSplashBackground() {
        if (intent.hasExtra(BACKGROUND_COLOR)) {
            ivBackground.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    intent.getIntExtra(BACKGROUND_COLOR, R.color.white)
                )
            )
        }
        if (intent.hasExtra(BACKGROUND_COLOR_VALUE)) {
            ivBackground.setBackgroundColor(Color.parseColor(intent.getStringExtra(BACKGROUND_COLOR_VALUE)))
        }

        if (intent.hasExtra(BACKGROUND_RESOURCE)) {
            ivBackground.setBackgroundResource(intent.getIntExtra(BACKGROUND_RESOURCE, R.color.white))
        }
    }

    private fun setFullScreen() {

        if (intent.hasExtra(FULL_SCREEN)) {

            if (intent.getBooleanExtra(FULL_SCREEN, false))
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.statusBarColor = Color.TRANSPARENT
                    window.navigationBarColor = Color.TRANSPARENT
                    window.setFlags(
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                    )
                }
        }

    }

    private fun setAnimation() {
        if (intent.hasExtra(ANIMATION_TYPE)) {
            val duration = intent.getLongExtra(ANIMATION_DURATION, 800)
            when (intent.getSerializableExtra(ANIMATION_TYPE)) {

                Splashy.Animation.SLIDE_IN_TOP_BOTTOM -> {
                    pbLoad.visibility = View.GONE

                    ivLogo.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_top)
                    tvTitle.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_bottom)
                    tvSubTitle.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_bottom)

                    ivLogo.animation.duration = duration
                    tvTitle.animation.duration = duration
                    tvSubTitle.animation.duration = duration

                    ivLogo.animation.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationRepeat(animation: Animation?) {}

                        override fun onAnimationStart(animation: Animation?) {}

                        override fun onAnimationEnd(animation: Animation?) {
                            if (progressVisible) pbLoad.visibility = View.VISIBLE
                        }

                    })
                }
                Splashy.Animation.SLIDE_IN_LEFT_BOTTOM -> {
                    pbLoad.visibility = View.GONE

                    ivLogo.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left)
                    tvTitle.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_bottom)
                    tvSubTitle.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_bottom)

                    ivLogo.animation.duration = duration
                    tvTitle.animation.duration = duration
                    tvSubTitle.animation.duration = duration

                    ivLogo.animation.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationRepeat(animation: Animation?) {}

                        override fun onAnimationStart(animation: Animation?) {}

                        override fun onAnimationEnd(animation: Animation?) {
                            if (progressVisible) pbLoad.visibility = View.VISIBLE
                        }

                    })
                }

                Splashy.Animation.SLIDE_IN_LEFT_RIGHT -> {
                    pbLoad.visibility = View.GONE

                    ivLogo.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left)
                    tvTitle.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right)
                    tvSubTitle.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right)

                    ivLogo.animation.duration = duration
                    tvTitle.animation.duration = duration
                    tvSubTitle.animation.duration = duration

                    ivLogo.animation.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationRepeat(animation: Animation?) {}

                        override fun onAnimationStart(animation: Animation?) {}

                        override fun onAnimationEnd(animation: Animation?) {
                            if (progressVisible) pbLoad.visibility = View.VISIBLE
                        }

                    })
                }

                Splashy.Animation.SLIDE_LEFT_ENTER -> {
                    pbLoad.visibility = View.GONE
                    tvTitle.visibility = View.INVISIBLE
                    tvSubTitle.visibility = View.INVISIBLE

                    ivLogo.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left)

                    ivLogo.animation.duration = duration


                    ivLogo.animation.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationRepeat(animation: Animation?) {}

                        override fun onAnimationStart(animation: Animation?) {}

                        override fun onAnimationEnd(animation: Animation?) {
                            if (progressVisible) pbLoad.visibility = View.VISIBLE
                            tvTitle.visibility = View.VISIBLE
                            tvSubTitle.visibility = View.VISIBLE
                            tvTitle.animation =
                                AnimationUtils.loadAnimation(this@SplashyActivity, R.anim.slide_from_logo)
                            tvSubTitle.animation =
                                AnimationUtils.loadAnimation(this@SplashyActivity, R.anim.slide_from_logo)
                            tvTitle.animation.duration = duration
                            tvSubTitle.animation.duration = duration
                            tvTitle.animation.fillAfter = false
                        }

                    })
                }
                Splashy.Animation.GLOW_LOGO -> {
                    val blinkAnimation = AlphaAnimation(1f, 0f) // Change alpha from fully visible to invisible
                    blinkAnimation.duration = duration // duration - half a second
                    blinkAnimation.interpolator = LinearInterpolator() // do not alter animation rate
                    blinkAnimation.repeatCount = -1 // Repeat animation infinitely
                    blinkAnimation.repeatMode = Animation.REVERSE
                    ivLogo.animation = blinkAnimation
                }
                Splashy.Animation.GLOW_LOGO_TITLE -> {
                    val blinkAnimation = AlphaAnimation(1f, 0f) // Change alpha from fully visible to invisible
                    blinkAnimation.duration = duration // duration - half a second
                    blinkAnimation.interpolator = LinearInterpolator() // do not alter animation rate
                    blinkAnimation.repeatCount = -1 // Repeat animation infinitely
                    blinkAnimation.repeatMode = Animation.REVERSE
                    ivLogo.animation = blinkAnimation
                    tvTitle.animation = blinkAnimation
                }
            }
        }
    }

    private fun setTime() {
        if (intent.hasExtra(TIME)) {
            time = intent.getLongExtra(TIME, time)
        }
        if (intent.hasExtra(INFINITE_TIME)) {
            isIntermediate = intent.getBooleanExtra(INFINITE_TIME, false)
        }
    }


    internal fun setOnComplete(getComplete: Splashy.OnComplete) {
        onComplete = getComplete

    }

    private fun showSplashy() {
        Handler().postDelayed({
            if (onComplete != null) {
                onComplete?.onComplete()
            }
            finish()
        }, time)
    }

    internal fun hideSplashy() {
        //  instance.finishAffinity()
        if (onComplete != null) {
            onComplete?.onComplete()

        }

    }


    override fun onBackPressed() {}


}
