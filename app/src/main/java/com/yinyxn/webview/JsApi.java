package com.yinyxn.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.TextView;

/**
 * Created by yinyxn on 2016/1/12.
 */
public class JsApi {

    Context context;
    private TextView textView;

    public JsApi(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void showMsg(String text){
        textView.setText(text);
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
