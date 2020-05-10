package cn.coco.annotationtest.Inject;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class InjectUtil {

    // 反射获取view
    public static void injectView(Activity activity){
        Class<? extends Activity> cls = activity.getClass();

        // 获取此类的所有成员
        Field[] declaredFields = cls.getDeclaredFields();
        for(Field filed:declaredFields){
            // 判断属性是否被InjectView注解
            if(filed.isAnnotationPresent(InjectView.class)){
                InjectView injectView = filed.getAnnotation(InjectView.class);
                //获取注解中设置的id
                int id = injectView.value();
                View view = activity.findViewById(id);
                //反射设置属性的值
                filed.setAccessible(true); //设置访问权限，允许操作private的属性
                try {
                    //反射赋值
                    filed.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 反射获取传递的参数
    public static void injectData(Activity activity){
        Class<? extends Activity> cls = activity.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(Field filed:fields){
            if(filed.isAnnotationPresent(InjectData.class)){
                InjectData temp = filed.getAnnotation(InjectData.class);
                String str = temp.value();
                String value = activity.getIntent().getStringExtra(str);
                //反射设置属性的值
                filed.setAccessible(true); //设置访问权限，允许操作private的属性
                try {
                    //反射赋值
                    filed.set(activity,value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
