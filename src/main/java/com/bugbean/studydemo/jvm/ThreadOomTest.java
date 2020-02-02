package com.bugbean.studydemo.jvm;

public class ThreadOomTest {
    public static void main(String[] args) {
        ThreadOomTest threadOomTest = new ThreadOomTest();
        threadOomTest.oomByThread();
    }

    private void dontStop() {
        while (true) {

        }
    }

    public void oomByThread(){
        while (true){
            new Thread(() -> dontStop()).start();
        }
    }
}
