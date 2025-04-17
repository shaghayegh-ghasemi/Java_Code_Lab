package com.bounteous.priority;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskManager {
    private final int maxQueueSize;
    private final int numProducers;
    private final int numConsumers;
    private final int taskPerProducer;
    private final PriorityBlockingQueue<Task<Integer, Integer>> queue;
    private final Metric metrics;

    public TaskManager(int maxQueueSize, int numProducers, int numConsumers, int taskPerProducer) {
        this.maxQueueSize = maxQueueSize;
        this.numProducers = numProducers;
        this.numConsumers = numConsumers;
        this.taskPerProducer = taskPerProducer;
        this.queue = new PriorityBlockingQueue<>(maxQueueSize);
        this.metrics = new Metric();
    }

    public void start() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        int totalTasks = numProducers * taskPerProducer;

        // Start producers
        for (int i = 0; i < numProducers; i++) {
            Thread t = new Thread(new TaskProducer("Producer-" + i, taskPerProducer, queue, metrics));
            threads.add(t);
            t.start();
        }

        Thread.sleep(100); // delay to allow tasks buildup

        // Start consumers
        for (int i = 0; i < numConsumers; i++) {
            Thread t = new Thread(new TaskConsumer("Consumer-" + i, queue, metrics));
            threads.add(t);
            t.start();
        }

        // join producers
        for (int i = 0; i < numProducers ; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                threads.get(i).interrupt();
            }
        }

        // send poison pill
        for (int i = 0; i < numConsumers ; i++) {
            queue.put(new Task<>(Priority.LOW, -1, n -> {
                throw new RuntimeException("Pison Pill");
            }));
        }

        // join consumers
        for (int i = numProducers; i < threads.size() ; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                threads.get(i).interrupt();
            }
        }

        // Report metrics
        System.out.println("\n=== METRICS ===");
        System.out.println("Total tasks produced: " + metrics.producedCount.get());
        System.out.println("Total tasks consumed: " + metrics.consumedCount.get());
        System.out.println("Total processing time (ns): " + metrics.totalProcessingTime.get());
        System.out.println("Average processing time (ms): " + metrics.getAverageProcessingTime());
    }

}
