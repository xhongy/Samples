package com.aa.patchlib;

import android.content.Context;
import android.widget.Toast;

public class MyClass {
    public static String test = "bug 修复了";
    public static void ShowLog(Context c, String info){
        Toast.makeText(c,info +" now myclass is "+test,Toast.LENGTH_SHORT).show() ;
    }
}
