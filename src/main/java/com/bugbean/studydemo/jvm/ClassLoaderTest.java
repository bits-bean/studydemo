package com.bugbean.studydemo.jvm;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        System.out.println(parent.getClass().getClassLoader());
    }
}
