package com.bugbean.studydemo.jvm;

public class FinalEscapeGC {
    public static FinalEscapeGC SAVE_HOOK = null;

    public void isLive() {
        System.out.println("Yes,i'm live");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
        FinalEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalEscapeGC();

        //1
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isLive();
        } else {
            System.out.println("No,i'm dead");
        }

        //2
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isLive();
        } else {
            System.out.println("No,i'm dead");
        }
    }
}
