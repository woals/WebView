package com.yinyxn.webview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        textView = (TextView) findViewById(R.id.textView);


        // 启动 JS
        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setSupportZoom(true);//支持缩放

        // 缩放
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.getSettings().setBlockNetworkImage(true);//关掉图片加载

        // 设置为 WebViewClient(这样设置就不会跳转到浏览器上)
        webView.setWebViewClient(new MyClient());
//        webView.setWebViewClient(new WebViewClient());

//        JsApi jsApi = new JsApi(this);
//        jsApi.setTextView(textView);
//        webView.addJavascriptInterface(jsApi, "MyAndroid");
//        webView.loadUrl("file:///android_asset/abc.html");


//        webView.loadData("完整的<html>代码","text/html","utf-8");
//        webView.loadUrl("http://m.douban.com");
        webView.loadUrl("http://jianshu.com");

    }
    class MyClient extends WebViewClient{
        /**
         *  开始加载页面
         *
         * @param view  事件源webView
         * @param url   加载的页面的URL（有大量的数据）
         * @param favicon   位图（网站的小图标）
         */
        @Override
        public void onPageStarted(
                WebView view,
                String url,
                Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(webView.canGoBack()){//是否可以返回
                webView.goBack();//返回
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);//没有返回就退出
    }
}
