package com.lab.inmotion.learny.GIF;

import android.content.Context;
import android.webkit.WebView;

/**
 * Created by user on 24/11/2015.
 */
public class GifWebView extends WebView {


    public GifWebView(Context context,String path) {
        super(context);
        loadUrl(path);

    }
}
