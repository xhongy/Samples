package cn.coco.annotationtest;

import java.io.Serializable;

public class CustomerSericalizable implements Serializable {
    private int id;
    private String name;
    private int age;

    public CustomerSericalizable() {
        super();
    }

    public CustomerSericalizable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
