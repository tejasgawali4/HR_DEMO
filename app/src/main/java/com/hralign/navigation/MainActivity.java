package com.hralign.navigation;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

public class MainActivity extends MasterBaseActivity {
    WebView webView;
    Context ctx;
    String activityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.setLayout(R.layout.activity_main);
        super.setDrawerID(R.id.main_layout);
        super.onCreate(savedInstanceState);
        ctx = this.getBaseContext();
        activityName = "MainActivity";
        setContextFromActivity(ctx, activityName);

//        setContentView(R.layout.activity_main);

/*
        webView = (WebView) findViewById(R.id.webView);
        // force web view to open inside application
        webView.setWebViewClient(new MyWebViewClient());
        openURL();*/
    }

/*    private void openURL() {
        webView.loadUrl("http://www.netersontech.com/aboutus.php");
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }*/
}
