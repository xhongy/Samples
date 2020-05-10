package cn.coco.annotationlib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD}) //允许在类与类属性上标记该注解
@Retention(RetentionPolicy.SOURCE) // 注解保留在源码中
public @interface AnnotationTest {
    String value(); // `无默认值`
    int age() default 1; //有默认值
}