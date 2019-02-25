package com.dizoo.invitetask.module.web;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dizoo.baselibrary.base.BaseActivity;
import com.dizoo.invitetask.constant.CommonConstant;
import com.dizoo.invitetask.R;
import com.just.agentweb.AgentWeb;

public class WebActivity extends BaseActivity {

    private TextView toobarTitle;
    private ImageButton toobarBack;
    private LinearLayout webView;

    private AgentWeb agentWeb;
    private String title;
    private String link;

    @Override
    public int layoutId() {
        return R.layout.activity_web;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        toobarTitle = findViewById(R.id.toobar_title);
        toobarBack = findViewById(R.id.toobar_back);
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        title = intent.getStringExtra(CommonConstant.WEB_TITLE);
        link = intent.getStringExtra(CommonConstant.WEB_LINK);
        toobarTitle.setText(isNullOrEmpty(title) ? getString(R.string.app_name) : title);
        toobarBack.setOnClickListener(listener);
        initAgentWeb();
    }

    @Override
    protected void onResume() {
        agentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        agentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (agentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initAgentWeb(){
        int progressbarColor = ContextCompat.getColor(this,R.color.colorAccent);
        agentWeb = AgentWeb.with(this)
                .setAgentWebParent(webView,new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator(progressbarColor, 2)// TODO: 2019/2/25 网页进度条颜色
                .createAgentWeb()
                .ready()
                .go("https://www.jianshu.com/p/d97a0761a7a6");
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!agentWeb.back()) {
                finish();
            }
        }
    };
}
