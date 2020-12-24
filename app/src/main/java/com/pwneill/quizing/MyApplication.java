package com.pwneill.quizing;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static com.pwneill.quizing.MyApplication mInstance;
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        this.setAppContext(getApplicationContext());
    }

    public static com.pwneill.quizing.MyApplication getInstance(){
        return mInstance;
    }
    public static Context getAppContext() {
        return mAppContext;
    }
    public void setAppContext(Context mAppContext) {
        this.mAppContext = mAppContext;
    }
}
