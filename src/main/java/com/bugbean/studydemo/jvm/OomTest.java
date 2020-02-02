package com.bugbean.studydemo.jvm;

import java.util.ArrayList;
import java.util.List;

public class OomTest {

    static class OomObject{

    }

    public static void main(String[] args) {
        List<OomObject> list = new ArrayList<>();
        while (true){
            list.add(new OomObject());
        }
    }
}
