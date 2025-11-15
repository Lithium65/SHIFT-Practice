package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static volatile boolean isRunning = true;

    public static void main(String[] args) {

        TaskHandler taskHandler = new TaskHandler();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads.add(new Thread(() ->
            {
                consumerTask(finalI, taskHandler);
            }));

            threads.add(new Thread(() ->
            {
                producerTask(finalI, taskHandler);
            }));
        }

        threads.forEach(Thread::start);
    }

    private static void producerTask(int finalI, TaskHandler taskHandler) {
        while (!currentThread().isInterrupted() && isRunning) {
            try {
                currentThread().setName("producer" + finalI);
                sleep(ThreadLocalRandom.current().nextInt(1, 11) * 1000L);
                taskHandler.addTask("Task - "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void consumerTask(int finalI, TaskHandler taskHandler) {
        while (!currentThread().isInterrupted()) {
            try {
                currentThread().setName("consumer" + finalI);
                LOGGER.info(Thread.currentThread().getName() + " consumed task " + taskHandler.getTask());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
