package com.bugbean.studydemo.jvm;

public class AnimalTest {
    public void test(Animal animal) {
        animal.hunt();
    }

    public static void main(String[] args) {
        while (true){

        }
    }
}

interface Animal {
    void hunt();
}

class Dog implements Animal {

    @Override
    public final void hunt() {
        System.out.println("wa");
    }

    public native void asd();
}