package org.example;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static int num = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        int threadCount = new Random().nextInt(11) + 5;
        int incrementsPerThread = 10000 / threadCount;
        int remainder = 10000 % threadCount;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            int increments = incrementsPerThread + (i < remainder ? 1 : 0);
            executor.submit(() -> {
                for (int j = 0; j < increments; j++) {
                    lock.lock();
                    num++;
                    lock.unlock();
                }
                latch.countDown();
            });
        }

        latch.await();
        executor.shutdown();

        System.out.println("Final num: " + num);
    }
}