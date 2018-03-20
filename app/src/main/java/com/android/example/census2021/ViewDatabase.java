package com.android.example.census2021;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ViewDatabase extends AppCompatActivity {

    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_database);


        webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);
        String baseUrl = "https://console.firebase.google.com/u/4/project/census-2018/database/census-2018/data";
        String data = null;
        String mimeType = "application/ecmascript";
        String encoding = "UTF-8";
        String historyUrl = "https://console.firebase.google.com/u/4/project/census-2018/database/census-2018/data";
//        webView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        // String baseUrl = "https://www.google.co.in";
        webView.loadUrl(baseUrl);
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
