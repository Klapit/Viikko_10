package com.example.viikko_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    String url;

    EditText textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        textInput = findViewById(R.id.osoite);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        //web.getSettings().setJavaScriptEnabled(true);
    }

    public void loadPage(View v){
        //web.loadUrl(findViewById(R.id.osoite).toString());
        url = textInput.getText().toString();
        if (url.equals("index.html") ){
            web.loadUrl("file:///android_asset/index.html");
        } else {
            web.loadUrl("http://" + url);
        }
    }

    public void executeJavascript(View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void initialize(View v){
        web.evaluateJavascript("javascript:initialize()", null);
    }
}

//testaillaan xxx