package com.example.faustocheca.webviewasynctaskw;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by faustocheca on 29/8/16.
 */
public class MyWebViewClient extends WebViewClient {


    public MyWebViewClient() {
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        view.loadUrl(url);
        return true;
    }
}
