package com.example.mewol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.example.mewol.R.id.webView;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    private String myUrl = "http://";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹뷰 셋팅
        mWebView = (WebView) findViewById(webView);//xml 자바코드 연결
        mWebView.getSettings().setJavaScriptEnabled(true);//자바스크립트 허용

        mWebView.loadUrl("http://매월매주.com");//웹뷰 실행
        mWebView.setWebChromeClient(new WebChromeClient());//웹뷰에 크롬 사용 허용//이 부분이 없으면 크롬에서 alert가 뜨지 않음
        mWebView.setWebViewClient(new WebViewClient());//새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용


    }
    //폰의 뒤로가기 버튼의 동작 입력
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//뒤로가기 버튼 이벤트
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {//웹뷰에서 뒤로가기 버튼을 누르면 뒤로가짐
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }
}
