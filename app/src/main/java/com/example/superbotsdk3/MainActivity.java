package com.example.superbotsdk3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import com.example.sdkbotlibraray.CustomRelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomRelativeLayout relativeLayout = new CustomRelativeLayout(this);
        ConstraintLayout constraintLayout =  findViewById(R.id.parent);
        relativeLayout.init("EBPLMG1oKA","hjMLEum5CPlgNx1T9IWlBlOaJZ4l4EObDY2Fw0JQ");
        constraintLayout.addView(relativeLayout);
    }
}
