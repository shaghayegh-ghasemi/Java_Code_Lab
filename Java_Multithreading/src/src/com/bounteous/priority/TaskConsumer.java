package com.bounteous.priority;

import java.util.concurrent.PriorityBlockingQueue;

public class TaskConsumer implements Runnable{
    private final String name;
    private final PriorityBlockingQueue<Task<Integer, Integer>> queue;
    private final Metric metrics;

    public TaskConsumer(String name, PriorityBlockingQueue<Task<Integer, Integer>> queue, Metric metrics) {
        this.name = name;
        this.queue = queue;
        this.metrics = metrics;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                Task<Integer, Integer> task = queue.take(); // take does not return null, it'll wait until queue becomes full
                if (task.getInput() == -1) break; // poison pill
                int output = task.operation.apply(task.getInput());

                long start = System.nanoTime();
                long end = System.nanoTime();
                long processingTime = end - start;
                metrics.totalProcessingTime.addAndGet(processingTime);
                metrics.consumedCount.incrementAndGet();

                System.out.println("[" + name + "] processed " + task.getInput() +
                        " → " + output + " | priority: " + task.getPriority() +
                        " | time: " + (processingTime / 1_000_000) + " ms");

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer [" + name + "] interrupted!");
            Thread.currentThread().interrupt();
        }
    }
}
