# librarybotsdk
To get a Libraray into your build:

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

Step 4 Added Internet permission

	 <uses-permission android:name="android.permission.INTERNET"></uses-permission>

