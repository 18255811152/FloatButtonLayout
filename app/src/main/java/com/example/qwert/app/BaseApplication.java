package com.example.qwert.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化 AndroidUtilCode
         */
        Utils.init(this);
    }
}
