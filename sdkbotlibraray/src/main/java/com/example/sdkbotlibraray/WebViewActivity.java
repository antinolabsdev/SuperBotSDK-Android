package com.example.sdkbotlibraray;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView mWebView;
    private  ImageView iv_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

               this.getWindow()
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        setContentView(R.layout.activity_web_view);
        mWebView = findViewById(R.id.webview);
        iv_close = findViewById(R.id.iv_close);
        WebSettings webSettings= mWebView.getSettings();
        mWebView.setId((int)0X100);
        mWebView.setScrollContainer(false);
        mWebView.setBackgroundColor(0x00000000);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        Intent intent = getIntent();
        String url = intent.getStringExtra("webview");
        mWebView.loadUrl(url);

        iv_close.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        WebViewActivity.super.onBackPressed();
    }
}
