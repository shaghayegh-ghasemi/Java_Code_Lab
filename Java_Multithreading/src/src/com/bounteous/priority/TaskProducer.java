package com.bounteous.priority;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.function.Function;

public class TaskProducer implements Runnable{
    private final Random random = new Random();
    private final String name;
    private final int numTasks;
    private final PriorityBlockingQueue<Task<Integer, Integer>> queue; // shared queue
    private final Metric metrics;

    public TaskProducer(String name, int numTasks, PriorityBlockingQueue<Task<Integer, Integer>> queue, Metric metrics) {
        this.name = name;
        this.queue = queue;
        this.numTasks = numTasks;
        this.metrics = metrics;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numTasks; i++){
                Priority priority = assignPriority(); // task priority
                int input = random.nextInt(50); // operation input
                Function<Integer, Integer> operation = n -> n * n; // task operation
                Task<Integer, Integer> task = new Task<>(priority, input, operation); // creating the task
                queue.put(task);
                metrics.producedCount.incrementAndGet();

                System.out.println("[" + name + "] produced task - calculating square of " + input + " with priority " + priority + ".");

                Thread.sleep(100);
            }
        } catch (InterruptedException e){
            System.out.println("Producer [" + name + "] interrupted!");
            Thread.currentThread().interrupt();
        }
    }

    private Priority assignPriority(){
        int choice = random.nextInt(3);
        return switch (choice){
            case 0 -> Priority.HIGH;
            case 1 -> Priority.MEDIUM;
            default -> Priority.LOW;
        };
    }
}
