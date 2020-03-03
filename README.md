<p align="left">
<a href="http://www.customerly.io">
  <img src="https://pinnacle.works/site/wp-content/uploads/revslider/home-w/superbots-1.png" alt="" data-ww="['500px','500px','406px','406px']" data-hh="['90px','90px','73px','73px']" width="500" height="90" data-no-retina="" style="width: 322.984px; height: 58.1371px; transition: none 0s ease 0s; text-align: inherit; line-height: 0px; border-width: 0px; margin: 0px; padding: 0px; letter-spacing: 0px; font-weight: 400; font-size: 8px;">
</p>
<h1>Live Chat Android SDK from Pinnacle</h1>
 [![Android API23+](https://img.shields.io/badge/Android-API_14+-green.svg)]()
  [![Java 7+](https://img.shields.io/badge/Java-6+-red.svg)]()
 <p align="center">
  <img src="https://cdn.worldvectorlogo.com/logos/Java-1.svg" width=25 alt="Icon"/> <b>Java fully supported</b>
</p>
## Features

- [x] Register your users
- [x] Set attributes
- [x] Track events
- [x] Support via chat in real time
- [x] Surveys
- [x] English & Italian localizations
- [x] Many more is coming....
## Requirements

- Android Lollipop, 5.1 (API level 14+)
- Android Studio 2.0+
- Java 7+
(Pinnacle Works also with pure Java projects)
## Setup Pinnacle SDK

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2 Add the dependency

	dependencies {
	        implementation 'com.github.antinolabsdev:librarybotsdk:0.1.0'
	}
  
Step 3 Write compileOptions in

	android{
	  compileOptions {
		sourceCompatibility JavaVersion.VERSION_1_8
		targetCompatibility JavaVersion.VERSION_1_8
	    }
	}
	
Step 4 Write these line in our code 
	
	1.  Create the instance the of the custom layout
	2.  Connected with the parent layout.
	3.  Call the method of the custom layout and pass the parameters action and secret
	4   Add the view with customLayout.
	
	     CustomRelativeLayout relativeLayout = new CustomRelativeLayout(this);
	     ConstraintLayout constraintLayout =  findViewById(R.id.parent);
	     relativeLayout.init(action,secret);
	     constraintLayout.addView(relativeLayout);

Step 5 Added Internet permission

	 <uses-permission android:name="android.permission.INTERNET"></uses-permission>
	 
	 
## Acknowledgements

Made with ❤️ by [Prakhar Pandey](https://www.linkedin.com/in/prakhar-pandey-59a79616a/) for Antino.

