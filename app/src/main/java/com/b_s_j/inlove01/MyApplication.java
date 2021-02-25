package com.b_s_j.inlove01;

import android.app.Application;

//import androidx.multidex.MultiDexApplication;

import com.kakao.sdk.common.KakaoSdk;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, "30320ff14dca1ed591c45255cac0daa7");
    }
}

