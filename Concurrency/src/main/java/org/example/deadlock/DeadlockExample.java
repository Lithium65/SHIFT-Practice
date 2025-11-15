package org.example.deadlock;


public class DeadlockExample {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Lock1 was blocked " + Thread.currentThread().getName());
                synchronized (lock2) {
                    System.out.println("Lock2 was blocked " + Thread.currentThread().getName());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Lock2 was blocked " + Thread.currentThread().getName());
                synchronized (lock1) {
                    System.out.println("Lock1 was blocked " + Thread.currentThread().getName());
                }
            }

        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main thread was finished");
    }

}
