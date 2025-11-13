package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static int num = 0;
    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Callable<Integer> task = () -> {
                for (int j = 0; j < 10000; j++) {
                    lock.lock();
                    num++;
                    lock.unlock();
                }
                return num;
            };
            futures.add(executor.submit(task));
        }

        for (Future<Integer> future : futures) {
            future.get();
        }

        executor.shutdown();

        System.out.println("Final value: " + num);
    }
}