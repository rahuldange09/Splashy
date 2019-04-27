package com.rbddevs.splashy

import android.app.Activity
import android.content.Intent
import android.widget.ImageView

class Splashy(private var activity: Activity) {

    private var intent: Intent = Intent(activity, SplashyActivity::class.java)


//    *************************************** Splash Screen Time *********************************************************

    /**
     * @param time The long value  to set Time of Splash Screen in Millis
     * Default time = 2000ms
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setTime(time: Long = 2000): Splashy {
        intent.putExtra(SplashyActivity.TIME, time)
        return this
    }

    /**
     * @param yes The boolean value to show Splash screen for infinite time
     * This can be stopped using Splashy.hide()
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setInfiniteDuration(yes: Boolean): Splashy {
        intent.putExtra(SplashyActivity.INFINITE_TIME, yes)
        return this

    }


//    *************************************** Splash Screen Title *********************************************************

    /**
     * @param show The boolean value to show title or not
     *Default show = true
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun showTitle(show: Boolean): Splashy {
        intent.putExtra(SplashyActivity.SHOW_TITLE, show)
        return this
    }

    /**
     * @param title The string value to set Title
     * Default title = Splashy
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setTitle(title: String): Splashy {
        intent.putExtra(SplashyActivity.TITLE, title)
        return this
    }



    fun setTitle(title: Int): Splashy {
        intent.putExtra(SplashyActivity.TITLE_RESOURCE, title)
        return this
    }


    /**
     * @param color The int value to set Title color from colors.xml
     * Default color = R.color.black
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setTitleColor(color: Int): Splashy {
        intent.putExtra(SplashyActivity.TITLE_COLOR, color)
        return this
    }


    /**
     * @param colorValue The string value to set Title color in Color HEX
     * Default color = "#000000"
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setTitleColor(colorValue: String): Splashy {
        intent.putExtra(SplashyActivity.TITLE_COLOR_VALUE, colorValue)
        return this
    }


    /**
     * @param titleSize The float value to set Title text size
     * Default titleSize = 40F
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setTitleSize(titleSize: Float): Splashy {
        intent.putExtra(SplashyActivity.TITLE_SIZE, titleSize)
        return this
    }


//    *************************************** Splash Screen Title *********************************************************


    /**
     * @param subtitle The string value to set Title
     * Default title = Splashy
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setSubTitle(subtitle: String): Splashy {
        intent.putExtra(SplashyActivity.SUBTITLE, subtitle)
        return this
    }

    fun setSubTitle(subtitle: Int): Splashy {
        intent.putExtra(SplashyActivity.SUBTITLE_RESOURCE, subtitle)
        return this
    }


    /**
     * @param color The int value to set Title color from colors.xml
     * Default color = R.color.gray
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setSubTitleColor(color: Int): Splashy {
        intent.putExtra(SplashyActivity.SUBTITLE_COLOR, color)
        return this
    }


    /**
     * @param colorValue The string value to set Title color in Color HEX
     * Default color = "#000000"
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setSubTitleColor(colorValue: String): Splashy {
        intent.putExtra(SplashyActivity.SUBTITLE_COLOR_VALUE, colorValue)
        return this
    }


    /**
     * @param subtitleSize The float value to set Title text size
     * Default subtitleSize = 18F
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setSubTitleSize(subtitleSize: Float): Splashy {
        intent.putExtra(SplashyActivity.SUBTITLE_SIZE, subtitleSize)
        return this
    }


    /**
     * @param italic The boolean value to set subtitle italic
     * Default italic = true
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */

    fun setSubTitleItalic(italic: Boolean): Splashy {
        intent.putExtra(SplashyActivity.SUBTITLE_ITALIC, italic)
        return this
    }


    //    *************************************** Splash Screen Logo *********************************************************

    /**
     * @param show The boolean value to show Logo or not
     * Default show = true
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun showLogo(show: Boolean): Splashy {
        intent.putExtra(SplashyActivity.SHOW_LOGO, show)
        return this
    }


    /**
     * @param logo The int value to ser logo using id (R.drawwable.logo)
     * Default logo = R.drawable.splashy
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setLogo(logo: Int): Splashy {
        intent.putExtra(SplashyActivity.LOGO, logo)
        return this
    }

    fun setLogoWHinDp(width: Int, height: Int): Splashy {
        intent.putExtra(SplashyActivity.LOGO_WIDTH, width)
        intent.putExtra(SplashyActivity.LOGO_HEIGHT, height)
        return this
    }

    fun setLogoScaleType(scaleType: ImageView.ScaleType): Splashy {
        intent.putExtra(SplashyActivity.LOGO_SCALE_TYPE, scaleType)
        return this
    }


    //    *************************************** Splash Screen Progress *********************************************************


    /**
     * @param show The boolean value to show Progress Bar on Screen or not
     * Default show = false
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun showProgress(show: Boolean): Splashy {
        intent.putExtra(SplashyActivity.SHOW_PROGRESS, show)
        return this
    }

    /**
     * @param color the int value to set Progress Bar tint color
     * Default color = R.color.colorAccent
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setProgressColor(color: Int): Splashy {
        intent.putExtra(SplashyActivity.PROGRESS_COLOR, color)
        return this
    }


    /**
     * @param color the string value to set Progress Bar tint color
     * Default color = "#000000"
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setProgressColor(color: String): Splashy {
        intent.putExtra(SplashyActivity.PROGRESS_COLOR_VALUE, color)
        return this
    }





    //    *************************************** Splash Screen Mix *********************************************************


    /**
     * @param color The int value to set background color of whole screen
     * Default color : R.color.white
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setBackgroundColor(color: Int): Splashy {
        intent.putExtra(SplashyActivity.BACKGROUND_COLOR, color)
        return this
    }

    /**
     * @param colorValue The string value to set background color in color hex of whole screen
     *Default colorValue = "#ffffff"
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setBackgroundColor(colorValue: String): Splashy {
        intent.putExtra(SplashyActivity.BACKGROUND_COLOR_VALUE, colorValue)
        return this
    }

    /**
     * @param backgroundResource The int value to set background image of whole screen
     * Default backgroundResource = R.drawable.white
     *
     * @return  Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     */
    fun setBackgroundResource(backgroundResource: Int): Splashy {
        intent.putExtra(SplashyActivity.BACKGROUND_RESOURCE, backgroundResource)
        return this
    }


    fun setAnimation(type: Animation, duration: Long = 800): Splashy {
        intent.putExtra(SplashyActivity.ANIMATION_TYPE, type)
        intent.putExtra(SplashyActivity.ANIMATION_DURATION, duration)
        return this
    }


    fun setFullScreen(yes: Boolean)  : Splashy{
        intent.putExtra(SplashyActivity.FULL_SCREEN, yes)
        return this
    }


//    *************************************** Finally Splash Screen Show *********************************************************


    /**
     * Finally shows Splash screen
     */
    fun show() {
        activity.startActivity(intent)


    }

    enum class Animation {
        SLIDE_IN_TOP_BOTTOM, SLIDE_IN_LEFT_BOTTOM, SLIDE_IN_LEFT_RIGHT,SLIDE_LEFT_ENTER, GLOW_LOGO, GLOW_LOGO_TITLE
    }

    companion object {


        /**
         * @param getComplete The interface value to listen when splash screen time ends
         *
         *
         * @return  Returns the same Intent object, for chaining multiple calls
         * into a single statement.
         */
        fun onComplete(getComplete: OnComplete) {
            val splashy = SplashyActivity()
            splashy.setOnComplete(getComplete)
        }

        /**
         * This hides Splash screen
         */
        fun hide() {
            val splashy = SplashyActivity()
            splashy.hideSplashy()
        }


    }


    /**
     *
     * Interface used as listener when Splash Screen ends
     *
     */
    interface OnComplete {
        fun onComplete()
    }


}
