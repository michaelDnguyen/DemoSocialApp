package com.example.nntai.mycompanyapp.base;

import android.app.Application;
import android.content.res.Configuration;

import com.example.nntai.mycompanyapp.constant.myLog;
import com.zing.zalo.zalosdk.oauth.ZaloSDKApplication;

/**
 * Created by nn.tai on 09/04/2018.
 */

public class myApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ZaloSDKApplication.wrap(this);
        myLog.e("Application onCreate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        myLog.e("Application onConfigChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        myLog.e("Application onLowMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        myLog.e("Application Terminate");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        myLog.e("Application onTrimMemory");
    }

}
