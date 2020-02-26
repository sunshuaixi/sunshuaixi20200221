package com.bawei.sunshuaixi20200221.base;

import android.app.Application;
import android.content.Context;

/**
 * TIme:2020/2/26
 * Author:孙帅喜
 * Descriotion:
 */
public class App extends Application {

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

    public static Context appContext(){
        return applicationContext;
    }
}
