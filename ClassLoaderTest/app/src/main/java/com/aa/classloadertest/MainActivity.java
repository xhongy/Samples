package com.aa.classloadertest;

import androidx.appcompat.app.AppCompatActivity;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.aa.patchlib.MyClass;

import java.io.IOException;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(this,"oh,my god 出错了",Toast.LENGTH_LONG).show();
        MyClass.ShowLog(MainActivity.this,"wa! 好了");

//        Toast.makeText(this,"wa! 好了",Toast.LENGTH_SHORT).show();
        //dalvik.system.PathClassLoader
        ClassLoader classLoader = MainActivity.this.getClassLoader();
        Log.d("coco", classLoader+"");
        Log.d("coco", "getClassLoader 的父亲 :"+classLoader.getParent());
        // java.lang.BootClassLoader@
        ClassLoader dd1 = Activity.class.getClassLoader();
        Log.d("coco", dd1+"");

        try {
            DexFile dexFile = new DexFile("/xxx/xx.dex");
            Enumeration<String> entries = dexFile.entries();
            //遍历  dex中所有的Class
            while (entries.hasMoreElements()){
                String clsName = entries.nextElement();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
