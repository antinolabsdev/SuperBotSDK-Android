package com.example.superbotsdk3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sdkbotlibraray.CustomRelativeLayout;

public class MainActivity extends AppCompatActivity {

    EditText editTextAction;
    EditText editTextSecret;
    Button buttonGO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomRelativeLayout relativeLayout = new CustomRelativeLayout(this);
        ConstraintLayout constraintLayout =  findViewById(R.id.parent);
        editTextAction = findViewById(R.id.enter1);
        editTextSecret = findViewById(R.id.back);
        buttonGO = findViewById(R.id.button);
        buttonGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = editTextAction.getText().toString();
                String secret = editTextSecret.getText().toString();
                relativeLayout.init(action,secret);
            }
        });

        constraintLayout.addView(relativeLayout);
    }
}
