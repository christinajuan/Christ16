package com.example.user.christ16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        initWebView();
    }
    private void initWebView(){
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new ChristJS(), "brad");

        // 1.
        //webView.loadUrl("http://www.iii.org.tw");
        // 2 .
        webView.loadUrl("file:///android_asset/Christ.html");
        // 3.
        //webView.loadData("<h1>Brad Company</h1>","text/html;charset=utf-8",null);
    }
    private class MyWebViewClient extends WebViewClient {
    }
    private void test1(View v){
        String name = "Peter";
        webView.loadUrl("Javascript:test1('"+name+"')");
    }
    private class ChristJS{
        @JavascriptInterface
        public void showUrName(String myname){
            Log.v("brad", "OK: " + myname);}
    }
}
