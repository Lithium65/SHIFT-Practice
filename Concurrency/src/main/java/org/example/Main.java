package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static int num = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        int threadCount = new Random().nextInt(11) + 5;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            int target = new Random().nextInt(5000) + 1000;
            Thread t = new Thread(() -> {
                for (int j = 0; j < target; j++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + " прерван");
                        break;
                    }
                    lock.lock();
                    try {
                        if (num >= 10000) {
                            break;
                        }
                        num++;
                    } finally {
                        lock.unlock();
                    }
                }
            }, "Worker-" + i);
            threads.add(t);
            executor.submit(t);
        }

        while (true) {
            lock.lock();
            try {
                if (num >= 10000) {
                    System.out.println("Достигли 10000, прерываем все потоки...");
                    for (Thread t : threads) {
                        t.interrupt();
                    }
                    break;
                }
            } finally {
                lock.unlock();
            }
            Thread.sleep(10);
        }

        executor.shutdown();
        System.out.println("Threads: " + threadCount);
        System.out.println("Final num: " + num);
    }
}
