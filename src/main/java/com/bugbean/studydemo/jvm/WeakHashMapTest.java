package com.bugbean.studydemo.jvm;

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";

        weakHashMap.put(key,value);
        System.out.println(weakHashMap);

//        key = null;
//        System.out.println(weakHashMap);

        System.gc();
        System.out.println(weakHashMap);

    }
}
