# Splashy
<p>A Splash screen library for Android developed in Kotlin provides customizations and amazing animations by ease.</p>
	<b>It works with both Java and Kotlin.</b>

[ ![Download](https://api.bintray.com/packages/rahuldange/Splashy/com.rbddevs.splashy/images/download.svg?version=1.1.0) ](https://bintray.com/rahuldange/Splashy/com.rbddevs.splashy/1.1.0/link)
![SDK 15+](https://img.shields.io/badge/API-15%2B-brightgreen.svg) 
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Splashy-orange.svg?style=flat-square)](https://android-arsenal.com/details/1/7638)


<div align="center">
  <p align="center">Built with ❤︎ by
	  <a href="https://github.com/rahuldange09">Rahul Dange</a></p>
</div>
<br>

![image](https://raw.githubusercontent.com/rahuldange09/Splashy/master/images/slide_top_bottom.gif)&nbsp;&nbsp;&nbsp;&nbsp;
![image](https://github.com/rahuldange09/Splashy/blob/master/images/slide_left_right_with_bg.gif)
![image](https://raw.githubusercontent.com/rahuldange09/Splashy/master/images/blink_logo.gif)
## 💻 Installation
Add this in your app's build.gradle file:
```groovy
dependencies {
  implementation 'com.rbddevs.splashy:splashy:1.1.0'
  implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.21+" // For JAVA Only
}
```

Or add Splashy as a new dependency inside your pom.xml

```xml
<dependency>
	<groupId>com.rbddevs.splashy</groupId>
	<artifactId>splashy</artifactId>
	<version>1.1.0</version>
	<type>pom</type>
</dependency>
```

## ❔ Usage
**Basic Usage**
``` kotlin
 	Splashy(this)  // For JAVA : new Splashy(this)
            .setLogo(R.drawable.splashy)
            .setTitle("Splashy")
            .show()

```

**Advanced Usage**
``` kotlin
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
	
	// Call it immediately after any setContentView() for quick launch
	setSplashy()
}

fun setSplashy(){
	Splashy(this) 		 // For JAVA : new Splashy(this)
            .setLogo(R.drawable.splashy)
            .setTitle("Splashy")
	    .setTitleColor("#FFFFFF")
	    .setSubTitle("Splash screen made easy")
	    .setProgressColor(R.color.white)
	    .setBackgroundResource("#000000")
 	    .setFullScreen(true)
	    .setTime(5000)
            .show()	    
}
	    
```
**Splashy.hide()  AND  Splashy.onComplete(getComplete: OnComplete)**
``` kotlin
fun checkLogin(){
	Splashy(this).setInfiniteDuration(true).show()   // For JAVA : new Splashy(this)

	// Some mock example response operation 
	Response.onResponse(object  : Response.onResponse{
		override fun onResponse(response){
			Splashy.hide()				// Hide after operation
		}

	}

	// Listener for completion of splash screen
	Splashy.onComplete(object : Splashy.OnComplete {
            override fun onComplete() {
	           Toast.makeText(this@MainActivity, "Logged In", Toast.LENGTH_SHORT).show()
            }

        })
}

```


## 🎨 Customization and Attributes

All customizable attributes for Splashy
<table>
    <th>Attribute Name</th>
    <th>Default Value</th>
    <th>Description</th>
	<tr>
		<td>setLogo(resId : Int)</td>
		<td>R.drawable.splashy</td>
		<td>The main logo for Splashy</td>
	</tr>
	<tr>
		<td>setTitle(resId : Int) <br> OR <br> setTitle(value : String)</td>
		<td>R.string.app_name <br> OR <br> "Splashy"</td>
		<td>The main title for Splashy either from strings.xml or string value</td>
	</tr>
	<tr>
		<td>setTime(timeInMs : Long)</td>
		<td>2000</td>
		<td>The time to show Splashy in Millisecond </td>
	</tr>
	<tr>
		<td>setSubTitle(resId : Int) <br> OR <br> setSubTitle(value : String)</td>
		<td>R.string.subtitle <br> OR <br> "Splash screen made easy"</td>
		<td>The subtitle for Splashy either from strings.xml or string value. This also enables subtitle.</td>
	</tr>
	<tr>
		<td>setInfiniteDuration(yes: Boolean)</td>
		<td>false</td>
		<td>Sets splash screen for infinite time if "true". Can be dismissed by calling Splashy.hide() </td>
	</tr>
	<tr>
		<td>showTitle(show: Boolean)</td>
		<td>true</td>
		<td>To show title or not.</td>
	</tr>
	<tr>
		<td>setTitleColor(color: Int) <br> OR <br> setTitleColor(colorValue: String)</td>
		<td>R.color.black <br> OR <br> "#000000"</td>
		<td>The color of title either resource id from strings.xml OR HEX value.</td>
	</tr>
	<tr>
		<td>setTitleSize(titleSize: Float)</td>
		<td>40F</td>
		<td>The size of title text in float.</td>
	</tr>
	<tr>
		<td>setSubTitleColor(color: Int) <br> OR <br> setSubTitleColor(colorValue: String)</td>
		<td>R.color.gray <br> OR <br> "#888888"</td>
		<td>The color of sub title either resource id from strings.xml OR HEX value.</td>
	</tr>
	<tr>
		<td>setSubTitleSize(titleSize: Float)</td>
		<td>16F</td>
		<td>The size of title text in float.</td>
	</tr>
		<tr>
		<td>setSubTitleItalic(italic : Boolean)</td>
		<td>true</td>
		<td>To set subtitle in italic style or not.</td>
	</tr>
	<tr>
		<td>showLogo(show: Boolean)</td>
		<td>true</td>
		<td>To show Logo or not.</td>
	</tr>
	<tr>
		<td>setLogoWHinDp(width: Int, height: Int)</td>
		<td>(200, 200)</td>
		<td>To set Logo Width(W) and Height(H) in DP.</td>
	</tr>
	<tr>
		<td>setLogoScaleType(scaleType: ImageView.ScaleType)</td>
		<td> ImageView.ScaleType.CENTER_CROP </td>
		<td>To set default scale type of Logo. <br> Eg. ImageView.ScaleType.CENTER_CROP,  CENTER, FIT_XY and others</td>
	</tr>
	<tr>
		<td>showProgress(show: Boolean)</td>
		<td>false</td>
		<td>To show circular progress bar or not.</td>
	</tr>
	<tr>
		<td>setProgressColor(resId: Int) <br> OR <br> setProgressColor(value: String)</td>
		<td>R.color.black <br> OR <br> "#000000"</td>
		<td>To set color of progressbar either resource id from strings.xml OR HEX value. Also enables progressbar</td>
	</tr>
	<tr>
		<td>setBackgroundColor(resId: Int) <br> OR <br> setBackgroundColor(value: String)</td>
		<td>R.color.white <br> OR <br> "#FFFFFF"</td>
		<td>The background of Splash screen either resource id from strings.xml OR HEX value.</td>
	</tr>	
	<tr>
		<td>setBackgroundResource(resId: Int)</td>
		<td>R.drawable.bg</td>
		<td>The background resource for splash screen from drawable.</td>
	</tr>
	<tr>
		<td>setAnimation(type: Animation, duration: Long)</td>
		<td>(NONE,800)</td>
		<td>The amazing splash screen animations with duration. <br> Eg. (Splashy.Animation.SLIDE_IN_TOP_BOTTOM, 800) , Types: SLIDE_IN_TOP_BOTTOM,  SLIDE_IN_LEFT_BOTTOM,  SLIDE_IN_LEFT_RIGHT,  SLIDE_LEFT_ENTER,  GLOW_LOGO,  GLOW_LOGO_TITLE</td>
	</tr>
	<tr>
		<td>setFullScreen(yes: Boolean)</td>
		<td>false</td>
		<td>To show splashy full screen or not.</td>
	</tr>
	<tr>
		<td>show()</td>
		<td>--</td>
		<td>Finally shows splash screen. </td>
	</tr>
	<tr>
		<td>Splashy.onComplete(getComplete: OnComplete)</td>
		<td>--</td>
		<td>Listener when splash screen ends to perform some operations</td>
	</tr>
	<tr>
		<td>Splashy.hide()</td>
		<td>--</td>
		<td>Hides splash screen. Helpful when set to infinite duration. </td>
	</tr>
</table>

# 📃 License

    Copyright 2018 Rahul Dange

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

	
	
