package org.example;

public class MyThread extends Thread {
    private int id;

    public MyThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            Main.num.incrementAndGet();
        }
    }
}
