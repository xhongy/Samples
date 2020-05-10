package cn.coco.annotation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

// 添加要处理的注解
@SupportedAnnotationTypes("cn.coco.annotationlib.AnnotationTest")
public class MyClass extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Messager messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE, "ss");
        messager.printMessage(Diagnostic.Kind.NOTE, "ss"+set.toString());
        return false;
    }
}
