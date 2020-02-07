package com.bugbean.studydemo.jvm;

public class Test {
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int k = i + j;
    }

    public void test1() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        int c = a + 1;
    }

    public void test2() {
        int a = 0;
        int c = a + 1;
        if (a == 1) {
            int b = 0;
            b = a + 1;
        } else {
            int e=9;
            System.out.println();
        }
    }
}
