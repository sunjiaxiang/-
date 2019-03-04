package com.example.dell.zhihu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private WebView mWan;
    private String url;
    private String title;
    private Toolbar mMato;
    private String id;
    private int ti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

          url = intent.getStringExtra("url");
          title = intent.getStringExtra("title");
        initView();
    }

    private void initView() {
        mWan = (WebView) findViewById(R.id.wan);
        mWan.setWebViewClient(new WebViewClient());
            mWan.loadUrl(url);

        mMato = (Toolbar) findViewById(R.id.mato);
        mWan.setOnClickListener(this);
        mMato.setTitle(title);
        setSupportActionBar(mMato);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.wan:

                break;
        }
    }
}
