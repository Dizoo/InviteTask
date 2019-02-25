package com.dizoo.baselibrary;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;

public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        fontSize();
    }

    /**
     * 加载系统默认设置，字体不随用户设置变化
     */
    private void fontSize(){
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }
}
