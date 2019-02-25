package com.dizoo.invitetask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dizoo.baselibrary.base.BaseActivity;
import com.dizoo.baselibrary.event.BindEventBus;
import com.dizoo.baselibrary.event.Event;
import com.dizoo.baselibrary.util.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Eventbus测试类
 * 在需要的接收数据的类加注解"@BindEventBus"，不需要在调用订阅，取消订阅的方法
 * callIntent()是Activity跳转的方法
 */
@BindEventBus
public class EventBusActivity extends BaseActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_event;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(Event<String> event){
        ToastUtils.show(this, "测试EventBus");
    }


    public static Intent callIntent(Context context) {
        Intent intent = new Intent(context, EventBusActivity.class);
        return intent;
    }
}
