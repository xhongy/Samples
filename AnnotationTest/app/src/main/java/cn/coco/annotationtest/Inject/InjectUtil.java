package cn.coco.annotationtest.Inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class InjectUtil {
    // 反射获取view
    public static void injectView(Activity activity){
        if (null == activity) return;
        Class<? extends Activity> cls = activity.getClass();
        // 获取此类的所有成员
        Field[] declaredFields = cls.getDeclaredFields();
        for(Field field:declaredFields){//获取Activity类里面声明的所有成员变量
            // 判断属性是否被InjectView注解
            if(field.isAnnotationPresent(InjectView.class)){
                InjectView injectView = field.getAnnotation(InjectView.class);
                //获取注解中设置的id
                int value = injectView.value();
                try{
                    // 找到findViewById方法
                    Method findViewById = cls.getMethod("findViewById",int.class);
                    findViewById.setAccessible(true);
                    Object view = findViewById.invoke(activity,value);
                    field.setAccessible(true);
                    field.set(activity,view);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    // 反射获取传递的参数
    public static void injectData(Activity activity){
        Class<? extends Activity> cls = activity.getClass();
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        if(extras == null){
            return;
        }

        //获得此类所有的成员
        Field[] fields = cls.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(InjectData.class)){
                InjectData temp = field.getAnnotation(InjectData.class);
                // 获取key
                String key = TextUtils.isEmpty(temp.value()) ? field.getName() : temp.value();
                if(extras.containsKey(key)){
                    Object obj = extras.get(key);
                    // todo Parcelable数组类型不能直接设置，其他的都可以.
                    //获得数组单个元素类型
                    Class<?> componentType = field.getType().getComponentType();
                    //当前属性是数组并且是 Parcelable（子类）数组
                    if(field.getType().isArray() && Parcelable.class.isAssignableFrom(componentType)) {
                        Object[] objs = (Object[]) obj;
                        //创建对应类型的数组并由objs拷贝
                        Object[] objects = Arrays.copyOf(objs, objs.length, (Class<? extends Object[]>) field.getType());
                        obj = objects;
                    }
                    //反射设置属性的值
                    field.setAccessible(true); //设置访问权限，允许操作private的属性
                    try {
                        //反射赋值
                        field.set(activity,obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}
