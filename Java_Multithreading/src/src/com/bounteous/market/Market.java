package com.bounteous.market;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Market {
    private static final int FRUIT_CAPACITY = 5; // Max quantity per fruit
    private final Map<Fruit, BlockingQueue<Fruit>> inventory;

    public Market() {
        inventory = new HashMap<>();
        for (Fruit fruit : Fruit.values()) {
            inventory.put(fruit, new ArrayBlockingQueue<>(FRUIT_CAPACITY));
        }
    }

    // Called by Farmer
    public void putFruit(Fruit fruit, String farmerName) throws InterruptedException {
        inventory.get(fruit).put(fruit); // Blocks if queue is full
        System.out.println("[" + farmerName + "] added " + fruit);
    }

    // Called by Consumer
    public Fruit takeFruit(Fruit fruit, String consumerName) throws InterruptedException {
        Fruit taken = inventory.get(fruit).take(); // Blocks if empty
        System.out.println("[" + consumerName + "] bought " + fruit);
        return taken;
    }
}
