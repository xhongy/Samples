package com.aa.classloadertest;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            PatchUtil.loadPatch(getApplicationContext(), "/sdcard/patch.dex");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
