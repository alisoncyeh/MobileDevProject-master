package com.example.herbert.utapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent i = getIntent();
        String url = i.getStringExtra("Url");
        WebView webview = (WebView) findViewById(R.id.webView);
        webview.loadUrl(url);

    }
}
