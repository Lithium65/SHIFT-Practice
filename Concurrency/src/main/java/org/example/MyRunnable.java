package org.example;

public class MyRunnable implements Runnable {
    private int id;

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("MyRunnable is running " + Thread.currentThread().getName() + "id: " + id);
    }
}
