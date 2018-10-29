package com.taoge.freereader.bean;

/**
 * created by：TangTao on 2018/10/15 15:23
 * <p>
 * email：xxx@163.com
 */
public class Girl {

    private String name;
    private int age;
    private char size;

    public Girl(String name, int age, char size) {
        this.name = name;
        this.age = age;
        this.size = size;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }
}
