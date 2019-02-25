package com.dizoo.invitetask.module.home;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;

import com.dizoo.baselibrary.base.BaseActivity;
import com.dizoo.baselibrary.util.ToastUtils;
import com.dizoo.http.bean.home.TabEntity;
import com.dizoo.invitetask.R;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private CommonTabLayout tabLayout;
    private static boolean isExit = false;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private int[] iconUnselected = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,};
    private int[] iconSelected = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,};
    private String[] tabText = {"首页", "项目", "导航", "我的"};
    private ArrayList<CustomTabEntity> tabEntities = new ArrayList<>();

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        tabLayout = findViewById(R.id.tabLayout);
        initFragment();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit ();
            return false;
        }
        return super.onKeyDown ( keyCode, event );
    }


    private void initFragment() {
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());
        for (int i = 0; i < tabText.length; i++) {
            tabEntities.add(new TabEntity(tabText[i],iconSelected[i], iconUnselected[i]));
        }
        tabLayout.setTabData(tabEntities,this,R.id.container,fragments);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtils.show ( MainActivity.this, "再按一次退出" );
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed ( 0, 2000 );
        } else {
            finish ();
            System.exit ( 0 );
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage ( msg );
            isExit = false;
        }
    };
}
