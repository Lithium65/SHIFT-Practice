package org.example.task2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Logger;

public class TaskHandler {

    private static final Logger LOGGER = Logger.getLogger(TaskHandler.class.getName());
    private Queue<String> queue = new ArrayDeque<>();



    public synchronized void addTask(String task) {
        queue.add(task);
        LOGGER.info(task + " was added to the queue");
        notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            //logger.warning("Queue is empty");
            wait();
        }
        return queue.poll();
    }

}
