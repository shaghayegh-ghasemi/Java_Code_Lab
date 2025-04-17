package com.bounteous.market;

import java.util.Random;

public class Farmer implements Runnable{
    private final Market market;
    private final String name;
    private final Random random = new Random();

    public Farmer(Market market, String name) {
        this.market = market;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Fruit fruit = Fruit.values()[random.nextInt(Fruit.values().length)];
                market.putFruit(fruit, name);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("[" + name + "] stopped producing.");
            Thread.currentThread().interrupt();
        }
    }
}
