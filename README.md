<p align="left">
<a href="https://pinnacle.works">
  <img src="https://pinnacle.works/site/wp-content/uploads/revslider/home-w/superbots-1.png" alt="" data-ww="['500px','500px','406px','406px']" data-hh="['90px','90px','73px','73px']" width="500" height="90" data-no-retina="" style="width: 322.984px; height: 58.1371px; transition: none 0s ease 0s; text-align: inherit; line-height: 0px; border-width: 0px; margin: 0px; padding: 0px; letter-spacing: 0px; font-weight: 400; font-size: 8px;">
</p>
<h1>Live Chat Android SDK from Pinnacle</h1>
<h2>  Live Chat for your mobile apps. Integrate painlessly the Live Chat for your customer support inside any Android App with  <a href="https://pinnacle.works/solutions/superbot/">SuperBot Live Chat SDK</a> </h2>

  [![Android API23+](https://img.shields.io/badge/Android-API_23+-green.svg)]()
  [![Java 6+](https://img.shields.io/badge/Java-6+-red.svg)]()
  [![License Apache 2.0](https://img.shields.io/badge/license-Apache%20License%202.0-red.svg)]()

**SuperBot** is the most complete <strong>Live Chat</strong> AI-driven Omni-channel conversation platform developed with the help of technologies like Machine Learning and Artificial Intelligence powered by Google Algorithms for assisting organizations to attend their online queries. 

The Bot’s intelligence is backed by high data analytics and research.The AI technology used, makes it smarter every second, as it empowers the Bot with a Self-Learning Capability. 

The SuperBot Live Chat Android SDK is really simple to integrate in your apps, and allow your users to contact you via chat.

## Requirements

- Android Lollipop, 5.1 (API level 23+)
- Android Studio 2.0+
- Java 7+
(Pinnacle Works also with pure Java projects)
## Setup Pinnacle SDK

## Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

## Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.antinolabsdev:librarybotsdk:1.1'
	}
  
## Step 3. Write compileOptions in

	android{
	  compileOptions {
		sourceCompatibility JavaVersion.VERSION_1_8
		targetCompatibility JavaVersion.VERSION_1_8
	    }
	}
	
## Step 4. Write these line in our code 
	
	1.  Create the instance the of the custom layout
	2.  Connected with the parent layout.
	3.  Call the method of the custom layout and pass the parameters action and secret
	4   Add the view with customLayout.
	
	     CustomRelativeLayout relativeLayout = new CustomRelativeLayout(this);
	     ConstraintLayout constraintLayout =  findViewById(R.id.parent);
	     relativeLayout.init(action,secret);
	     constraintLayout.addView(relativeLayout);

## Step 5. Added Internet permission in Mainfest

	 <uses-permission android:name="android.permission.INTERNET"></uses-permission>
	 
## Contributing

- If you **need help** or you'd like to **ask a general question**, open an issue or contact our support on [SuperBot](https://pinnacle.works/solutions/superbot/)
- If you **found a bug**, open an issue.
- If you **have a feature request**, open an issue.
- If you **want to contribute**, submit a pull request.
	 
## Acknowledgements

Made with ❤️ by [Antino Labs](https://www.antino.io/) and [PinnacleWorks](https://pinnacle.works/).

## License
SuperBot is released under the MIT license. [See LICENSE](https://github.com/antinolabsdev/SuperBotSDK-Android/blob/master/LICENSE) for details.

