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

